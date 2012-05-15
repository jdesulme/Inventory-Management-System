/**
 * 
 */
package ims.DataLayer;


import ims.DataLayer.Common.ConnectionType;
import ims.DataLayer.Common.DataBase;
import ims.Model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Minh, Kumar, Jean
 *
 */
public class DataAccess {
        
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
   
    
    public int UpdateUser(int id, String user, String pass, String access){
        DataBase db = new DataBase(ConnectionType.MYSQL);
        int result = 0; 
        
        try {
            Connection conn = db.getConnection();
            CallableStatement cs = conn.prepareCall("{call sp_users(?,?,?,?)}");
            cs.setInt(1, id);
            cs.setString(2, user);
            cs.setString(3, pass);
            cs.setString(4, access);
            result = cs.executeUpdate();
            
            cs.close();
            conn.close();
        }
        catch(SQLException e) {
            System.err.println("SQL Error(s) as follows:");
            while (e != null) {
                System.err.println("SQL Return Code: " + e.getSQLState());
                System.err.println("  Error Message: " + e.getMessage());
                System.err.println(" Vendor Message: " + e.getErrorCode());
                e = e.getNextException();
            }	
        } 
        catch(Exception e) {
            System.err.println(e);
        }  
        
        return result;        
        
        
        
    }
    
    
    public int RemoveUser(int id){
        DataBase db = new DataBase(ConnectionType.MYSQL);
        int result = 0; 
        
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM login WHERE idLogin = ?");
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
        }
        catch(SQLException e) {
            System.err.println("SQL Error(s) as follows:");
            while (e != null) {
                System.err.println("SQL Return Code: " + e.getSQLState());
                System.err.println("  Error Message: " + e.getMessage());
                System.err.println(" Vendor Message: " + e.getErrorCode());
                e = e.getNextException();
            }	
        } 
        catch(Exception e) {
            System.err.println(e);
        }  
        
        return result;
                   
    }

    
    public void CreateProcedure() {
        DataBase db = new DataBase(ConnectionType.MYSQL);
        
        String queryDrop = "DROP PROCEDURE IF EXISTS sp_users";
        
        String query = "CREATE PROCEDURE sp_users "
            + " ( "
            + " IN p_id INT(11),  "
            + " IN p_user	 VARCHAR(45), "
            + " IN p_pass	 VARCHAR(45), "
            + " IN p_access	VARCHAR(45) "
            + " ) "
            + "BEGIN "
            + " UPDATE login "
            + " SET "
            + " username = p_user, "
            + " password = p_pass,"
            + " accessType = p_access"
            + " WHERE idLogin = p_id ; "
            + "END ";
        
        try {
            Connection conn = db.getConnection();
            Statement pstmtDrop = conn.createStatement();
            pstmtDrop.execute(queryDrop);
            pstmtDrop.close();
            
        }
        catch(SQLException e) {
            System.err.println("SQL Error(s) as follows:");
            while (e != null) {
                System.err.println("SQL Return Code: " + e.getSQLState());
                System.err.println("  Error Message: " + e.getMessage());
                System.err.println(" Vendor Message: " + e.getErrorCode());
                e = e.getNextException();
            }	
        } 
        catch(Exception e) {
            System.err.println(e);
        }      
        
        
        try {
            Connection conn = db.getConnection();
            Statement pstmt = conn.createStatement();
            pstmt.executeUpdate(query);
            pstmt.close();
            conn.close();
        }
        catch(SQLException e) {
            System.err.println("SQL Error(s) as follows:");
            while (e != null) {
                System.err.println("SQL Return Code: " + e.getSQLState());
                System.err.println("  Error Message: " + e.getMessage());
                System.err.println(" Vendor Message: " + e.getErrorCode());
                e = e.getNextException();
            }	
        } 
        catch(Exception e) {
            System.err.println(e);
        }  
    }
    
    
    
    public ArrayList<Login> GetLogin(){
            DataBase db = new DataBase(ConnectionType.MYSQL);
            ArrayList<Login> loginInfo = new ArrayList<>();
            
            try {
                Connection conn = db.getConnection();
                Statement pstmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = pstmt.executeQuery("SELECT idLogin, username, password, accessType FROM login");
                
                while( rs.next() ){
                    Login result = new Login( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) );
                    loginInfo.add(result);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(SQLException e) {
                System.err.println("SQL Error(s) as follows:");
                while (e != null) {
                    System.err.println("SQL Return Code: " + e.getSQLState());
                    System.err.println("  Error Message: " + e.getMessage());
                    System.err.println(" Vendor Message: " + e.getErrorCode());
                    e = e.getNextException();
                }	
            } 
            catch(Exception e) {
                System.err.println(e);
            }  
            
            return loginInfo;
        }
    
    
    
        public ArrayList<Login> GetLogin(String user){
            DataBase db = new DataBase(ConnectionType.MYSQL);
            ArrayList<Login> loginInfo = new ArrayList<>();
            
            try {
                Connection conn = db.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT username, password, accessType FROM login WHERE username = ?");
                pstmt.setString(1, user);
                
                ResultSet rs = pstmt.executeQuery();
                
                while( rs.next() ){
                    Login result = new Login( rs.getString(1), rs.getString(2), rs.getString(3) );
                    loginInfo.add(result);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch(SQLException e) {
                System.err.println("SQL Error(s) as follows:");
                while (e != null) {
                    System.err.println("SQL Return Code: " + e.getSQLState());
                    System.err.println("  Error Message: " + e.getMessage());
                    System.err.println(" Vendor Message: " + e.getErrorCode());
                    e = e.getNextException();
                }	
            } 
            catch(Exception e) {
                System.err.println(e);
            }  
            
            return loginInfo;
        }
    
    
    
	/**
	 * Gets the order list based upon the locality and date 
	 * 
	 */
	public ArrayList<Order> GetOrderList(Location locality){
		
		Location tempLocal = locality;
                //Sample Code
		DataBase db = new DataBase(ConnectionType.MYSQL);
                db.getConnection();
                    
		//Create orderList
		ArrayList<Order> orderList = new ArrayList<>();
                ArrayList<Ingredient> ingredientList = new ArrayList<>();
		
                try {
                    ResultSet rs;
                    Connection conn = db.getConnection();
                    String query = "SELECT b.idBranch, b.name, b.address, b.phone, b.city, o.idOrder, o.date, o.cost, "
                            + "i.name, i.quantityInStock, i.cost as unitPrice, i.unittype, oi.quantity "
                            + "FROM `warehouse`.`order` o "
                            + "JOIN `warehouse`.`branch` b ON (o.idBranch = b.idBranch) "
                            + "JOIN `warehouse`.`order_item` oi ON (o.idOrder = oi.idOrder) "
                            + "JOIN `warehouse`.`item` i ON (i.idItem = oi.idItem)";
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    rs = stmt.executeQuery(query);
                    
                    int idBranch = 0;
                    int idOrder = 0;
                    
                    while ( rs.next() ) {
                        Branch branch = null;
                        Order order;
                        
                        idBranch = rs.getInt(1);
                        idOrder = rs.getInt(6);
                        
                        Ingredient ingredient = new Ingredient(rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12));
                        ingredientList.add(ingredient);
                        
                        String bName = rs.getString(2);
                        String bAddress = rs.getString(3);
                        String bPhone = rs.getString(4);
                        String bCity = rs.getString(5);
                        
                        
                    
                        if ( rs.next() && idOrder != rs.getInt(6) ) {
                            String oOrderDate = rs.getString(7);
                            double oOrderCost = rs.getDouble(8);
                            branch = new Branch(bName, bAddress, bPhone, bCity);
                            order = new Order(idOrder, oOrderDate, branch, oOrderCost, ingredientList);
                            orderList.add(order);
                            ingredientList = new ArrayList<Ingredient>();
                        }
                        
                        rs.previous();
                    }
                    
                    stmt.close();
                    rs.close();
                    conn.close();       
                    
                }
                catch(SQLException e) {
                    System.err.println("SQL Error(s) as follows:");
                    while (e != null) {
                        System.err.println("SQL Return Code: " + e.getSQLState());
                        System.err.println("  Error Message: " + e.getMessage());
                        System.err.println(" Vendor Message: " + e.getErrorCode());
                        e = e.getNextException();
                    }	
                } 
                catch(Exception e) {
                    System.err.println(e);
                }  


             
                
		return orderList;
	}

	
	/**
	 * Gets all the pizza's that are currently in the system
	 * @return  
	 */
	public ArrayList<Pizza> GetPizzaList() {
		
            //DB code 
            DataBase db = new DataBase(ConnectionType.ODBC);
            ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
             try 
             {
                Connection connection = db.getConnection();
                
                String query = "SELECT Pizza.idPizza, Pizza_Ingredient.idIngredient, Pizza_Ingredient.quantity, Ingredient.name AS Ingredient_name, Ingredient.cost AS Ingredient_cost, Ingredient.unitType, Pizza.name AS Pizza_name, Pizza.size, Pizza.cost AS Pizza_cost"
                        + " FROM Pizza INNER JOIN (Ingredient INNER JOIN Pizza_Ingredient ON Ingredient.[idIngredient] = Pizza_Ingredient.[idIngredient]) ON Pizza.[idPizza] = Pizza_Ingredient.[idPizza]";


                //Prepare statement with query
                statement = connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
                
                resultSet = statement.executeQuery();
                
                int prevPizzaId = 0;
                ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
                
                while( resultSet.next() ){
                    
                    prevPizzaId = resultSet.getInt(1);
                    double quantity = resultSet.getDouble(3);
                    String name = resultSet.getString(4);
                    double ingredientCost = resultSet.getDouble(5);
                    String unitType = resultSet.getString(6);
                    Ingredient ingredient  = new  Ingredient(name,quantity,ingredientCost,unitType);
                    ingredientList.add(ingredient);              
          
                    String pizzaName = resultSet.getString(7);
                    String pizzaSize = resultSet.getString(8);
                    double cost = resultSet.getDouble(9);
                    
                    if(resultSet.next())
                    {
                        if(prevPizzaId != resultSet.getInt(1))
                        {
                            Pizza pizza = new Pizza (pizzaName,pizzaSize,ingredientList,cost); 
                            pizza.setPizzaId(prevPizzaId);
                            pizzaList.add(pizza);
                            ingredientList = new ArrayList<Ingredient>();
                        }
                    }
                    else
                    {
                        Pizza pizza = new Pizza (pizzaName,pizzaSize,ingredientList,cost); 
                        pizza.setPizzaId(prevPizzaId);
                        pizzaList.add(pizza);
                        //ingredientList.clear();
                        break;
                    }
                    resultSet.previous();
                }
                
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(SQLException e) {
                System.err.println("SQL Error(s) as follows:");
                while (e != null) {
                    System.err.println("SQL Return Code: " + e.getSQLState());
                    System.err.println("  Error Message: " + e.getMessage());
                    System.err.println(" Vendor Message: " + e.getErrorCode());
                    e = e.getNextException();
                }	
            } 
            catch(Exception e) {
                System.err.println(e);
            }  
		
		return pizzaList;
	}        
        /**
	 * Inserts Bill and returns bill no 
	 * @param pizzaName
	 * @param pizzaSize
	 * @return
	 */
        public int GenerateBillId(double totalCost, int branchId)
        {
             //DB code 
            DataBase db = new DataBase(ConnectionType.ODBC);
            int billId = 0; 
             try 
             {
                Connection connection = db.getConnection();
                
                String query = "INSERT INTO BILL (stamp,cost,idBranch) VALUES(?,?,?)";
               
                //Prepare statement with query
                 statement  = connection.prepareStatement(query);
                 
                 java.util.Date utilDate = new java.util.Date();

                statement.setDate(1, new Date(utilDate.getTime()));
                statement.setDouble(2, totalCost);
                statement.setInt(3,branchId);
                statement.executeUpdate();
           
               
               query = "SELECT idBill FROM BILL WHERE stamp = ? and cost = ? and idBranch = ?";
               statement  = connection.prepareStatement(query);
               
               statement.setDate(1, new Date(utilDate.getTime()));
               statement.setDouble(2, totalCost);
               statement.setInt(3,branchId);      
               
                resultSet = statement.executeQuery();
                
                while( resultSet.next() ){
                    billId = resultSet.getInt(1);                  
                }
                
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(SQLException e) {
                System.err.println("SQL Error(s) as follows:");
                while (e != null) {
                    System.err.println("SQL Return Code: " + e.getSQLState());
                    System.err.println("  Error Message: " + e.getMessage());
                    System.err.println(" Vendor Message: " + e.getErrorCode());
                    e = e.getNextException();
                }	
            } 
            catch(Exception e) {
                System.err.println(e);
            }  
             
             return billId;
        }
        
          /**
	 * Inserts Bill and returns bill no 
	 * @param pizzaName
	 * @param pizzaSize
	 * @return
	 */
        public void insertOrder(int billId, int pizzaId, int numofPizza)
        {
             //DB code 
            DataBase db = new DataBase(ConnectionType.ODBC);
          
             try 
             {
                Connection connection = db.getConnection();
                
                String query = "INSERT INTO PIZZA_BILL (idPizza,idBill,numOfPizza) VALUES(?,?,?)";
               
                //Prepare statement with query
                statement  = connection.prepareStatement(query);                

                statement.setInt(1, pizzaId);
                statement.setInt(2, billId);
                statement.setInt(3,numofPizza);
                statement.executeUpdate();//Insert to database
        
               
                statement.close();
                connection.close();
            }
            catch(SQLException e) {
                System.err.println("SQL Error(s) as follows:");
                while (e != null) {
                    System.err.println("SQL Return Code: " + e.getSQLState());
                    System.err.println("  Error Message: " + e.getMessage());
                    System.err.println(" Vendor Message: " + e.getErrorCode());
                    e = e.getNextException();
                }	
            } 
            catch(Exception e) {
                System.err.println(e);
            }  
            
        }
}
