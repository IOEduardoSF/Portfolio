import java.lang.reflect.Array;
import java.util.*;

public class MyVisitor extends PanteraBaseVisitor<Object>{

    private Map<String, Object> memory = new HashMap<>();
    //private Map<String, Object> functions = new HashMap<>();
    private boolean evalLoop = true;
    private boolean evalLoopBlock = true;
    @Override public Object visitProgram(PanteraParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitBlock(PanteraParser.BlockContext ctx) { return visitChildren(ctx);
    }

    @Override public Object visitIdentifier(PanteraParser.IdentifierContext ctx) {
        String id = ctx.VARIABLE().getText();
        /*if (!memory.containsKey(id)){
            System.err.println("Using a variable without assignment at: Line " + ctx.getStart().getLine());
            System.exit(0);
        }*/
        return memory.get(id);
    }

    @Override public Object visitFunctionDecl(PanteraParser.FunctionDeclContext ctx) {
        String nombre = ctx.name.getText();

        if (!ctx.identifier().isEmpty()){
            memory.put(nombre, ctx);
            return null;
            //return visitChildren(ctx);
        }
        memory.put(nombre, null);
        return visitChildren(ctx);
    }

    @Override public Object visitBlockStmt(PanteraParser.BlockStmtContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitPrintStmt(PanteraParser.PrintStmtContext ctx) {
        System.out.println(visit(ctx.expr()));
        return null;

    }

    @Override public Object visitContinueStmt(PanteraParser.ContinueStmtContext ctx) {
        evalLoopBlock = false;
        return false;
    }


    @Override public Object visitBreakStmt(PanteraParser.BreakStmtContext ctx) {
        evalLoop = false;
        return null;
    }

    @Override public Object visitReturnStmt(PanteraParser.ReturnStmtContext ctx) {
        if (ctx.expr().isEmpty()){
            return null;
        }
        return visit(ctx.expr());
    }

    @Override public Object visitIfStmt(PanteraParser.IfStmtContext ctx) {

        if (isNumeric(ctx.expr().getChild(0).getText())){
            memory.put("left", ctx.expr().getChild(0).getText());
        }
        if (isNumeric(ctx.expr().getChild(2).getText())) {
            memory.put("right", ctx.expr().getChild(2).getText());
        }

        if ((Boolean) visit(ctx.expr())){
            if (ctx.stmt() instanceof PanteraParser.ContinueStmtContext){
                return false;
            }
            visit(ctx.stmt());
        }
        return null;
    }

    @Override public Object visitIfElseStmt(PanteraParser.IfElseStmtContext ctx) {
        //visit(ctx.stmt(0));
        if ((Boolean) visit(ctx.expr())){
            visit(ctx.expr());
        }
        else if (ctx.Else() != null){
            visit(ctx.stmt(1));
        }
        return null;
    }

    @Override public Object visitForStmt(PanteraParser.ForStmtContext ctx) {
        int lb, ub;
        String var = ctx.VARIABLE().getText();
        String lower = ctx.lbound.getText();
        String upper = ctx.ubound.getText();
        memory.put(var, lower);

        if (!isNumeric(lower)){
           lb = (int) memory.get(lower);
        } else {
            String l = String.valueOf(lower);
            lb = Integer.parseInt(l);
        }

        if (!isNumeric(upper)){
            ub = (int) memory.get(upper);
        } else {
            String u = String.valueOf(upper);
            ub = Integer.parseInt(u);
        }

        for (int i = lb; i < ub; i++){
            if (!evalLoop){
                evalLoop = !evalLoop;
                break;
            } else if (!evalLoopBlock){
                evalLoopBlock = true;
                memory.put(var, i);
                continue;
            }
            memory.put(var, i);
            visit(ctx.stmt());
        }
        return null;
    }

    @Override public Object visitWhileStmt(PanteraParser.WhileStmtContext ctx) {
        //boolean flag = visit(ctx.expr()).equals(true);
        boolean flag = evalLoopBlock;
        while (visit(ctx.expr()).equals(true)){
            if (!evalLoop){
                evalLoop = !evalLoop;
                break;
            } else if (!evalLoopBlock){
                evalLoopBlock = true;
                continue;
            }
            // saber si el la ctx.stm instanceof Continue es False
            visit(ctx.stmt());
        }
        return null;
    }

    @Override public Object visitAssignStmt(PanteraParser.AssignStmtContext ctx) {
        String var = ctx.VARIABLE().getText();
        String value = ctx.rhs.getText();

        if (isNumeric(value)){
            int valor = Integer.parseInt(value);
            memory.put(var, valor);
            return valor;
        } else {
            memory.put(var, visit(ctx.expr())); // c, val == res = a + b -> c, res | ctx.expr() -> a + b  | memory(var,
        }
        return null;
    }

    @Override public Object visitAssignIdxStmt(PanteraParser.AssignIdxStmtContext ctx) {
        String nombre = ctx.expr().get(0).getText();
        //String indice = ctx.expr().get(1).getText();

        memory.put(nombre, visit(ctx.expr(1)));
        return visitChildren(ctx);
    }

    @Override public Object visitSingleStmt(PanteraParser.SingleStmtContext ctx) {
        return visit(ctx.expr());
    }

    @Override public Object visitNullStmt(PanteraParser.NullStmtContext ctx) { return visitChildren(ctx); }

    @Override public Object visitFuncCall(PanteraParser.FuncCallContext ctx) {
        String nombre = ctx.name.getText();
        PanteraParser.FunctionDeclContext functCtx = (PanteraParser.FunctionDeclContext) memory.get(nombre);

        for (int i = 0; i < functCtx.identifier().size() ; i++){
            memory.put(functCtx.identifier(i).getText(), visit(ctx.expr(i)));
        }

        return visitChildren((PanteraParser.FunctionDeclContext) memory.get(nombre));
        //return visitChildren(ctx);
    }

    @Override public Object visitTrueLiteral(PanteraParser.TrueLiteralContext ctx) {
        return true;
    }

    @Override public Object visitNumExpr(PanteraParser.NumExprContext ctx) { return visitChildren(ctx); }

    @Override public Object visitVarExpr(PanteraParser.VarExprContext ctx) {
        String id = ctx.VARIABLE().getText();
        /*if (!memory.containsKey(id)){
            System.err.println("Using a variable without assignment at: Line " + ctx.getStart().getLine());
            System.exit(0);
        }*/
        return memory.get(id);
    }

    @Override public Object visitNoneExpr(PanteraParser.NoneExprContext ctx) { return visitChildren(ctx); }

    @Override public Object visitListExpr(PanteraParser.ListExprContext ctx) {
        ArrayList<Object> lista = new ArrayList<>();
        for (int i = 0; i < ctx.expr().size(); i++){
            lista.add(ctx.expr(i).getText());
        }
        return lista;
    }

    @Override public Object visitBinExpr(PanteraParser.BinExprContext ctx) {
        String leftValue = "0";
        String rightValue = "0";
        Object left = 0;
        Object right = 0;

        if (ctx.expr().isEmpty()){
            leftValue = ctx.NUMERO(0).getText();
            rightValue = ctx.NUMERO(1).getText();
        } else if (ctx.expr().size() == 2){
            left = visit(ctx.expr(0));
            leftValue = String.valueOf(left);

            right = visit(ctx.expr(1));
            rightValue = String.valueOf(right); // if (5 < 6 & 7 > 6) then ...
        }

        String operator = ctx.op.getText();
        switch (operator){
            case "*":
                return Float.parseFloat(leftValue) * Float.parseFloat(rightValue);
            case "/":
                if (rightValue.equals("0")){
                    System.err.println("divide by zero at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getTokenIndex());
                    System.exit(0);
                }
                return Float.parseFloat(leftValue) / Float.parseFloat(rightValue);
            case "%":
                if (rightValue.equals("0")){
                    System.err.println("divide by zero at: Line " + ctx.getStart().getLine() + ", Position " + ctx.getStart().getTokenIndex());
                    System.exit(0);
                }
                return Float.parseFloat(leftValue) % Float.parseFloat(rightValue);
            case "+":
                return Float.parseFloat(leftValue) + Float.parseFloat(rightValue);
            case "-":
                return Float.parseFloat(leftValue) - Float.parseFloat(rightValue);
            case "<":
                return Float.parseFloat(leftValue) < Float.parseFloat(rightValue);
            case "<=":
                return Float.parseFloat(leftValue) <= Float.parseFloat(rightValue);
            case ">":
                return Float.parseFloat(leftValue) > Float.parseFloat(rightValue);
            case ">=":
                return Float.parseFloat(leftValue) >= Float.parseFloat(rightValue);
            case "==":
                return Float.parseFloat(leftValue) == Float.parseFloat(rightValue);
            case "!=":
                return Float.parseFloat(leftValue) != Float.parseFloat(rightValue);
            case "&":
                return (Boolean)left && (Boolean)right;
            case "|":
                return (Boolean)left || (Boolean)right;
            default:
                throw new RuntimeException("operador desconocido");
        }
    }

    @Override public Object visitParenExpr(PanteraParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override public Object visitUnaryExpr(PanteraParser.UnaryExprContext ctx) {
        String operator = ctx.op.getText();
        Object left = visit(ctx.expr());
        String leftValue = String.valueOf(left);

        switch (operator){
            case "+":
                return Float.parseFloat(leftValue) + 1;
            case "-":
                return Float.parseFloat(leftValue) - 1;
            case "!":
                return !Boolean.parseBoolean(leftValue);
        }
        return visitChildren(ctx);
    }

    @Override public Object visitIndexExpr(PanteraParser.IndexExprContext ctx) {
        String nombre = ctx.expr(0).getText();
        ArrayList lista = (ArrayList) memory.get(nombre);
        Integer index = (Integer) visit(ctx.expr(1));

        return lista.get(index);
    }

    @Override public Object visitFalseLiteral(PanteraParser.FalseLiteralContext ctx) {
        return false;
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Float.parseFloat(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
