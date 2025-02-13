// Generated from C:/Users/Israel/Desktop/Pantera/src/Pantera.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PanteraParser}.
 */
public interface PanteraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PanteraParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PanteraParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PanteraParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PanteraParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PanteraParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PanteraParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PanteraParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PanteraParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PanteraParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PanteraParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PanteraParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PanteraParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PanteraParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(PanteraParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PanteraParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(PanteraParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(PanteraParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(PanteraParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(PanteraParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(PanteraParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(PanteraParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(PanteraParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(PanteraParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(PanteraParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(PanteraParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(PanteraParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(PanteraParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(PanteraParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(PanteraParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(PanteraParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(PanteraParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(PanteraParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(PanteraParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(PanteraParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(PanteraParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(PanteraParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignIdxStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignIdxStmt(PanteraParser.AssignIdxStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignIdxStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignIdxStmt(PanteraParser.AssignIdxStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSingleStmt(PanteraParser.SingleStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSingleStmt(PanteraParser.SingleStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterNullStmt(PanteraParser.NullStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitNullStmt(PanteraParser.NullStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(PanteraParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(PanteraParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueLiteral(PanteraParser.TrueLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueLiteral(PanteraParser.TrueLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(PanteraParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(PanteraParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(PanteraParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(PanteraParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNoneExpr(PanteraParser.NoneExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNoneExpr(PanteraParser.NoneExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr(PanteraParser.BinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr(PanteraParser.BinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(PanteraParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(PanteraParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(PanteraParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(PanteraParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(PanteraParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(PanteraParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(PanteraParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(PanteraParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseLiteral(PanteraParser.FalseLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseLiteral(PanteraParser.FalseLiteralContext ctx);
}