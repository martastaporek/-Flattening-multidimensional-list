import java.util.ArrayList;
import java.util.List;

public class ListFlatter {

    List flatted = new ArrayList();


    public List getFlatted() {
        return flatted;
    }

    public void flaten(List nestedList) {

        for (Object elem : nestedList) {
            if (elem instanceof Iterable) {
                Iterable castedElem = (Iterable) elem;
                flatenList(castedElem);
            } else if (elem instanceof Object []) {
                Object[] castedElem = (Object[]) elem;
                flatenList(castedElem);
            }else if(elem.getClass().getName().equals("[I")){
                throw new IllegalArgumentException("Tables with privitives are not allowed");
            } else {
                this.flatted.add(elem);
            }
        }
    }




    private void flatenList(Iterable nestedElem) {

        for (Object elem : nestedElem) {
            if (elem instanceof Iterable) {
                Iterable castedElem = (Iterable) elem;
                flatenList(castedElem);
            } else if (elem instanceof Object []) {
                Object[] castedElem = (Object[]) elem;
                flatenList(castedElem);
            } else if(elem.getClass().getName().equals("[I")){
                throw new IllegalArgumentException("Tables with privitives are not allowed");
        } else {
            this.flatted.add(elem);
        }
        }

        }

    private void flatenList(Object[] nestedElem) {
        for (Object elem : nestedElem) {
            if (elem instanceof Iterable) {
                Iterable castedElem = (Iterable) elem;
                flatenList(castedElem);
            } else if (elem instanceof Object []) {
            Object [] castedElem = (Object[]) elem;
            flatenList(castedElem);
        } else {
            this.flatted.add(elem);
        }

            }
        }
    }
