package route.main;
import nez.ast.CommonTree;


public class Translator {
	public static CalcTree translate(CommonTree node){
		switch (node.getTag().getSymbol()) {
		case "Source":
			return new Source(node);
		case "Add":
			return new Add(translate(node.get(0)), translate(node.get(1)));
		case "Mul":
			return new Mul(translate(node.get(0)), translate(node.get(1)));
		case "Int":
			return new Int(Integer.parseInt(node.toText()));
		case "Name":
			return new Name(node.toString());//これで良いのか??
		case "LessThan":
			return new LessThan(translate(node.get(0)), translate(node.get(1)));
		case "GreaterThan":
			return new GreaterThan(translate(node.get(0)), translate(node.get(1)));
		case "LessThanEquals":
			return new LessThanEquals(translate(node.get(0)), translate(node.get(1)));
		case "GreaterThanEquals":
			return new GreaterThanEquals(translate(node.get(0)), translate(node.get(1)));
		case "Equals":
			return new Equals(translate(node.get(0)), translate(node.get(1)));
		case "NotEquals":
			return new NotEquals(translate(node.get(0)), translate(node.get(1)));
		case "In":
			return new In(translate(node.get(0))); 
		default:
			break;
		}
		return null;
	}
}
