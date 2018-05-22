import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListFlatter {

    List flatArray = new ArrayList();


    public List getFlatArray() {
        return flatArray;
    }

    public void flatten(List nestedList) {

        for (Object elem : nestedList) {
            if (elem instanceof Iterable) {
                Iterable castedElem = (Iterable) elem;
                flatten(castedElem);
            } else if (elem instanceof Object []) {
                Object[] castedElem = (Object[]) elem;
                flattenTable(castedElem);
            }else if(elem.getClass().getName().equals("[I") || elem instanceof Map){
                this.flatArray.add(new UnknownObject());
            } else {
                this.flatArray.add(elem);
            }
        }
    }


    private void flatten(Iterable nestedElem) {

        for (Object elem : nestedElem) {
            if (elem instanceof Iterable) {
                Iterable castedElem = (Iterable) elem;
                flatten(castedElem);
            } else if (elem instanceof Object[]) {
                Object[] castedElem = (Object[]) elem;
                flattenTable(castedElem);
            } else if (elem.getClass().getName().equals("[I") || elem instanceof Map) {
                this.flatArray.add(new UnknownObject());
            } else {
                this.flatArray.add(elem);
            }

        }
    }

    private void flattenTable(Object[] nestedElem) {
        for (Object elem : nestedElem) {
            if (elem instanceof Iterable) {
                Iterable castedElem = (Iterable) elem;
                flatten(castedElem);
                } else if (elem instanceof Object []) {
                    Object [] castedElem = (Object[]) elem;
                    flattenTable(castedElem);
                } else if(elem.getClass().getName().equals("[I") || elem instanceof Map){
                    this.flatArray.add(new UnknownObject());
                } else {
                    this.flatArray.add(elem);
            }
        }
    }
}
