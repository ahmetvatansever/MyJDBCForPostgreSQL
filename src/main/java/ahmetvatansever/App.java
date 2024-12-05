package ahmetvatansever;

import java.sql.*;

public class App
{
    public static void main( String[] args ) throws SQLException {

        String SQL_MYSELECT = "select * from public.test";
        String SQL_MYINSERT = "insert into public.test(ad) values ('AHMET')";
        String SQL_MYUPDATE = "update public.test " +
                "set ad= 'AHMET V.' " +
                "where id = 1";
        String SQL_MYDELETE = "DELETE FROM public.test WHERE id = 1";

        MyCrud myCrud = new MyCrud();

        System.out.println("*** SELECT ***");
        myCrud.myExecuteQuery(SQL_MYSELECT);

        System.out.println("*** INSERT ***");
        myCrud.myExecuteUpdate(SQL_MYINSERT);

        System.out.println("*** UPDATE ***");
        myCrud.myExecuteUpdate(SQL_MYUPDATE);

        System.out.println("*** DELETE ***");
        myCrud.myExecuteUpdate(SQL_MYDELETE);

    }
}
