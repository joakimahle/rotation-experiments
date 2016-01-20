package skitsamma.rotationexperiments;

public class ComplexObject {
    public String complexObjectAttribute;

    public ComplexObject(String id) {
        complexObjectAttribute = "Attribute of complex object for id = " + id;
    }

    @Override
    public String toString() {
        if(complexObjectAttribute != null) {
            return complexObjectAttribute;
        } else {
            return "complexObjectAttribute is NULL";
        }
    }
}
