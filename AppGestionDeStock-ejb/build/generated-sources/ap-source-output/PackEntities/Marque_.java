package PackEntities;

import PackEntities.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-20T22:17:29")
@StaticMetamodel(Marque.class)
public class Marque_ { 

    public static volatile SingularAttribute<Marque, String> origineFab;
    public static volatile ListAttribute<Marque, Produit> listeDesProduits;
    public static volatile SingularAttribute<Marque, String> nomMarque;

}