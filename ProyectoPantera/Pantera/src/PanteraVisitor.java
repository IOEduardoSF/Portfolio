// Generated from C:/Users/Israel/Desktop/Pantera/src/Pantera.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PanteraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PanteraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PanteraParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PanteraParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PanteraParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PanteraParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PanteraParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(PanteraParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PanteraParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(PanteraParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(PanteraParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(PanteraParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(PanteraParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(PanteraParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(PanteraParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(PanteraParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStmt(PanteraParser.IfElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(PanteraParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(PanteraParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(PanteraParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignIdxStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignIdxStmt(PanteraParser.AssignIdxStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStmt(PanteraParser.SingleStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullStmt}
	 * labeled alternative in {@link PanteraParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullStmt(PanteraParser.NullStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(PanteraParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueLiteral}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLiteral(PanteraParser.TrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(PanteraParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(PanteraParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoneExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneExpr(PanteraParser.NoneExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinExpr(PanteraParser.BinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(PanteraParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(PanteraParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(PanteraParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexExpr}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(PanteraParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseLiteral}
	 * labeled alternative in {@link PanteraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLiteral(PanteraParser.FalseLiteralContext ctx);
}