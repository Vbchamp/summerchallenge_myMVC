/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author Vaibhav
 */
public class Operations {

    private MyDbConnector con;

    public Operations() {
        con = new MyDbConnector();
    }

    public boolean isValid(String uid, String pwd) {
        try {
            con.connect();
            String query = "select * from LOGIN where userId='" + uid + "' and password='" + pwd + "'";
            int c = 0;
            java.sql.ResultSet rs = con.getResultSet(query);
            while (rs.next()) {
                c++;
            }
            if (c > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Vector<Blog> getBlogs() {
        Vector<Blog> blogs = null;
        try {
            con.connect();
            blogs = new Vector<Blog>(0, 1);
            String query = "select * from blogs order by date desc";
            java.sql.ResultSet rs = con.getResultSet(query);
            while (rs.next()) {
                Blog b = new Blog(rs.getString("message"), rs.getString("date"), rs.getString("blogger"), rs.getString("blog_id"));
                blogs.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public void deleteBlog(String id) {
        try {
            String query = "delete from blogs where blog_id='" + id + "'";
            con.connect();
            con.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertBlog(String blog, String user) {
        try {
            if (blog.contains("'")) {
                System.out.println("hai");
                blog = blog.replaceAll("'", "''");
            }
            System.out.println(blog);
            String query = "INSERT INTO APP.BLOGS (MESSAGE, \"DATE\", BLOGGER, BLOG_ID)"
                    + "VALUES ('" + blog + "', CURRENT_DATE, '" + user + "','" + user + "' || CAST(CURRENT_TIMESTAMP AS CHAR(23)))";
            con.connect();            
            con.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
