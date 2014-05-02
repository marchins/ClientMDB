package LogicaDominio;

import Enumerations.Formato;
import LogicaDominio.Account;
import LogicaDominio.Libro;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-02T17:17:28")
@StaticMetamodel(CopiaUtente.class)
public class CopiaUtente_ { 

    public static volatile SingularAttribute<CopiaUtente, String> copertinaLocale;
    public static volatile SingularAttribute<CopiaUtente, Integer> numeroCopia;
    public static volatile SingularAttribute<CopiaUtente, Account> account;
    public static volatile SingularAttribute<CopiaUtente, Formato> formato;
    public static volatile SingularAttribute<CopiaUtente, Libro> libro;

}