import java.util.*;

public class MyContainer extends ArrayList<Goods> {
    public class GoodsComparator implements Comparator<Goods> {

        public int compare(Goods g1, Goods g2) {
            if (g1.getName().compareTo(g2.getName()) != 0)
                return (g1.getName().compareTo(g2.getName()));
            else if (g1.getCountry().compareTo(g2.getCountry()) != 0)
                return (g1.getCountry().compareTo(g2.getCountry()));
            else
                return (g1.getNumber() - (g2.getNumber()));
        }
    }

    void sort() {

        GoodsComparator gComp = new GoodsComparator();
        Collections.sort(this, gComp);
    }

    TreeSet<String> getCountries(String name) {
        TreeSet<String> cSet = new TreeSet<String>();
        this.sort();
        Iterator<Goods> it = this.iterator();
        Goods goods;
        while (it.hasNext()) {
            goods = it.next();
            if (goods.getName().compareTo(name) > 0)
                break;
            else if (goods.getName().equals(name))
                cSet.add(goods.getCountry());
        }
        return cSet;
    }

    int getTotalValue(String name) {
        int res = 0;
        this.sort();
        Iterator<Goods> it = this.iterator();
        Goods goods;
        while (it.hasNext()) {
            goods = it.next();
            if (goods.getName().compareTo(name) > 0)
                break;
            else if (goods.getName().equals(name))
                res += goods.getNumber();
        }
        return res;
    }

    String show() {
        StringBuilder str = new StringBuilder();
        this.sort();
        Iterator<Goods> it = this.iterator();
        while (it.hasNext()) {
            str.append(it.next().toString());
            str.append("\n");
        }
        return str.toString();
    }
}