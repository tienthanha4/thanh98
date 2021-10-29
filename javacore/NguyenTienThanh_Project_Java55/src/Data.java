
@FunctionalInterface
/*   */ public interface Data {
/*   */   default String getColumns() {
/* 6 */     return "# The column's name place here";
/*   */   }
/*   */   
/*   */   String getLine();
/*   */ }
