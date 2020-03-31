package EntityPack;

import EntityPack.Tbladdress;
import EntityPack.Tblsubscription;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-31T18:03:17")
@StaticMetamodel(Tblcustomer.class)
public class Tblcustomer_ { 

    public static volatile SingularAttribute<Tblcustomer, String> fname;
    public static volatile SingularAttribute<Tblcustomer, String> lname;
    public static volatile CollectionAttribute<Tblcustomer, Tbladdress> tbladdressCollection;
    public static volatile CollectionAttribute<Tblcustomer, Tblsubscription> tblsubscriptionCollection;
    public static volatile SingularAttribute<Tblcustomer, Integer> cid;

}