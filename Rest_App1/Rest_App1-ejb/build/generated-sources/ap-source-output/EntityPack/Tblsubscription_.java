package EntityPack;

import EntityPack.Tblcustomer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-31T18:03:17")
@StaticMetamodel(Tblsubscription.class)
public class Tblsubscription_ { 

    public static volatile CollectionAttribute<Tblsubscription, Tblcustomer> tblcustomerCollection;
    public static volatile SingularAttribute<Tblsubscription, String> title;
    public static volatile SingularAttribute<Tblsubscription, String> type;
    public static volatile SingularAttribute<Tblsubscription, Integer> sid;

}