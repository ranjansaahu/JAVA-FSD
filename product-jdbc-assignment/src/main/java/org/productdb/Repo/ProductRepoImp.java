package org.productdb.Repo;

import org.productdb.Config.Database;
import org.productdb.Config.DatabaseImp;
import org.productdb.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImp implements ProductRepo {
    private Database database;

    public ProductRepoImp() {
        database = new DatabaseImp();
    }

    @Override
    public boolean addProduct(Product product) {
        String sql = "INSERT INTO product VALUES(?,?,?)";
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(sql);
            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getProductName());
            ps.setFloat(3, product.getProductQty());

            int count = ps.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        String sql = "UPDATE product SET productName=?, productQty=? WHERE productId=?";
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(sql);
            ps.setInt(3, product.getProductId());
            ps.setString(1, product.getProductName());
            ps.setFloat(2, product.getProductQty());

            int count = ps.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int productId) {
        String sql = "DELETE FROM product WHERE productId=?";
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(sql);
            ps.setInt(1, productId);

            int count = ps.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT * FROM product";
        try {
            Statement st = database.getConnection().createStatement();
            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                list.add(new Product(result.getInt(1), result.getString(2), result.getFloat(3)));
            }
            result.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product findById(int productId) {
        String sql = "SELECT * FROM product WHERE productId=?";
        Product product = null;
        try {
            PreparedStatement ps = database.getConnection().prepareStatement(sql);
            ps.setInt(1, productId);

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                product = new Product(result.getInt(1), result.getString(2), result.getFloat(3));
            }
            result.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void closeConnection() {
        try {
            database.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
