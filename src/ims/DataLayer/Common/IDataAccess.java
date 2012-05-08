/*
 * Interface DataAccess 
 * Common methods for accessing database
 */
package ims.DataLayer.Common;
import java.sql.*;
/**
 *
 * @author Saravana
 */
public interface IDataAccess {
    Connection GetConnection();
}
