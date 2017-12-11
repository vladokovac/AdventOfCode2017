import java.util.HashSet;
import java.util.Set;

/**
 * Created by vlado on 10/12/2017.
 */
public class AdventNode {

    private AdventNode _parent;
    private int _weight;
    private String _name;
    private Set<AdventNode> _children;

    public AdventNode(String name, int weight) {
        _name = name;
        _weight = weight;
        _parent = null;
        _children = new HashSet<>();
    }

    public AdventNode getParent() {
        return _parent;
    }

    public void setParent(AdventNode parent) {
        _parent = parent;
    }

    public String getName() {
        return _name;
    }

    public Set<AdventNode> getChildren() {
        return _children;
    }

    public void addChild(AdventNode child){
        _children.add(child);
    }

    public int getTreeWeight() {
        int totalWeight = _weight;
        for (AdventNode child : _children) {
            totalWeight += child.getTreeWeight();
        }
        return totalWeight;
    }

    public int getNodeWeight() {
        return _weight;
    }

    @Override
    public String toString() {
        return "AdventNode{" + ", _weight=" + _weight + ", _name='" + _name + '\'' + ", TreeWeight=" + this.getTreeWeight() + '}';
    }
}
