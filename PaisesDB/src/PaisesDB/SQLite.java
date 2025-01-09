package PaisesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {
	
	private Connection connection;
    private String databaseUrl;

   
    public void openConnection(String databaseType) {
        try {
            switch (databaseType.toLowerCase()) {
                case "sqlite":
                    databaseUrl = "jdbc:sqlite:C:/Users/2ag3.iorilope/paises.db";
                    connection = DriverManager.getConnection(databaseUrl);
                    System.out.println("SQLite konexioa ondo egin da.");
                    break;
                case "access":
                    databaseUrl = "jdbc:ucanaccess://C:/Users/2ag3.iorilope/paises.accdb";
                    connection = DriverManager.getConnection(databaseUrl);
                    System.out.println("Access konexioa ondo egin da.");
                    break;
                case "sqlserver":
                    databaseUrl = "jdbc:sqlserver://localhost:1433;databaseName=paises;user=sa;password=tu_contraseña";
                    connection = DriverManager.getConnection(databaseUrl);
                    System.out.println("SQL Server konexioa ondo egin da.");
                    break;
                default:
                    System.out.println("Aukeratu ezarritako datu-baseetako bat: SQLite, Access edo SQL Server.");
                    break;
            }
        } catch (SQLException e) {
            System.err.println("Errorea konexioa ezartzean: " + e.getMessage());
        }
    }


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Konexioa itxi da.");
            }
        } catch (SQLException e) {
            System.err.println("Errorea konexioa ixten: " + e.getMessage());
        }
    }


    public void selectData() {
        String sql = "SELECT * FROM kontinenteak";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Izena\t\tSuperficie\tHerrialde Kopurua\tPopulazioa");
            System.out.println("---------------------------------------------------------------");
            while (rs.next()) {
                String izena = rs.getString("Izena");
                double superficie = rs.getDouble("Superficie");
                int herrialdeKop = rs.getInt("Herrialde_Kop");
                long populazioa = rs.getLong("Populazioa");

                System.out.printf("%-10s\t%.2f\t\t%d\t\t\t%d%n", izena, superficie, herrialdeKop, populazioa);
            }
        } catch (SQLException e) {
            System.err.println("Errorea datuak eskuratzean: " + e.getMessage());
        }
    }

   
    public void clearTables() {
        String sql = "DELETE FROM kontinenteak";
        String sql2= "Delete from estatuak";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Taulak garbitu dira.");
        } catch (SQLException e) {
            System.err.println("Errorea taulak garbitzean: " + e.getMessage());
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql2);
            System.out.println("Taulak garbitu dira2.");
        } catch (SQLException e) {
            System.err.println("Errorea taulak garbitzean: " + e.getMessage());
        }
    }

   
    public void populateTables() {
    	String sql = "INSERT INTO kontinenteak (Izena, Superficie, Herrialde_Kop, Populazioa) " +
                "VALUES ('Europa', 10180000, 50, 746440), " +
                "('Asia', 4457900, 49, 46454775), " +
                "('Africa', 3037000, 54, 1340147), " +
                "('America', 3027000, 54, 1340147), " +
                "('Oceania', 2837000, 24, 1340147);";
        
    	 String sql2 = "INSERT INTO estatuak (Pais, Capital, Moneda, Superficie, Poblacion, Bizi_Esperantza, Kontinenteak_Izena) " +
                 "VALUES ('Holanda', 'Amsterdam', 'Euro', 41526, 15460000, 78, 'Europa'), " +
                 "('Andorra', 'Andorra La Vieja', 'Euro', 468, 64000, 0, 'Europa'), " +
                 "('Turkia', 'Ankara', 'Lira Turca', 783562, 61058000, 67, 'Asia'), " +
                 "('Madagascar', 'Antananarivo', 'Ariary', 587041, 13651000, 52, 'Africa'), " +
                 "('Samoa Occidental', 'Apia', 'Tala', 2831, 165000, 68, 'Oceania'), " +
                 "('Argelia', 'Argel', 'Dinar Argelino', 2381741, 27959000, 70, 'Africa'), " +
                 "('Eritrea', 'Asmara', 'Nakfa', 117600, 3400000, 0, 'Africa'), " +
                 "('Paraguay', 'Asuncion', 'Guaraní', 406752, 4828000, 68, 'America'), " +
                 "('Grecia', 'Atenas', 'Euro', 131957, 10467000, 78, 'Europa'), " +
                 "('Irak', 'Bagdad', 'Dinar Iraquí', 438317, 20097000, 66, 'Asia');";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Taulak datuekin bete dira.");
        } catch (SQLException e) {
            System.err.println("Errorea taulak betetzean: " + e.getMessage());
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql2);
            System.out.println("Taulak datuekin bete dira 2.");
        } catch (SQLException e) {
            System.err.println("Errorea taulak betetzean: " + e.getMessage());
        }
    }
    public void populateTablesaccess() {
    	 String sql = "INSERT INTO kontinenteak (Izena, Superficie, Herrialde_Kop, Populazioa) " +
                 "VALUES ('Europa', 10180000, 50, 7464440), " +
                 "('Asia', 44579000, 49, 46414775), " +
                 "('Africa', 30370000, 54, 1340547), " +
                 "('America', 30270000, 54, 13404147), " +
                 "('Oceania', 28370000, 24, 1340147)";
    	 

    	 String sql2 = "INSERT INTO estatuak (Pais, Capital, Moneda, Superficie, Poblacion, Bizi_Esperantza, Kontinenteak_Izena) " +
                 "VALUES ('Holanda', 'Amsterdam', 'Euro', 41526, 15460000, 78, 'Europa'), " +
                 "('Andorra', 'Andorra La Vieja', 'Euro', 468, 64000, 0, 'Europa'), " +
                 "('Turkia', 'Ankara', 'Lira Turca', 783562, 61058000, 67, 'Asia'), " +
                 "('Madagascar', 'Antananarivo', 'Ariary', 587041, 13651000, 52, 'Africa'), " +
                 "('Samoa Occidental', 'Apia', 'Tala', 2831, 165000, 68, 'Oceania'), " +
                 "('Argelia', 'Argel', 'Dinar Argelino', 2381741, 27959000, 70, 'Africa'), " +
                 "('Eritrea', 'Asmara', 'Nakfa', 117600, 3400000, 0, 'Africa'), " +
                 "('Paraguay', 'Asuncion', 'Guaraní', 406752, 4828000, 68, 'America'), " +
                 "('Grecia', 'Atenas', 'Euro', 131957, 10467000, 78, 'Europa'), " +
                 "('Irak', 'Bagdad', 'Dinar Iraquí', 438317, 20097000, 66, 'Asia');";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Taulak datuekin bete dira.");
        } catch (SQLException e) {
            System.err.println("Errorea taulak betetzean: " + e.getMessage());
        }
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql2);
            System.out.println("Taulak datuekin bete dira 2.");
        } catch (SQLException e) {
            System.err.println("Errorea taulak betetzean: " + e.getMessage());
        }
    }
}