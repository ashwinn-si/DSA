class Solution {
  boolean checkerCode(String code) {
    if (code.length() == 0) {
      return false;
    }
    for (char ch : code.toCharArray()) {
      if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '_') {
        continue;
      }
      return false;
    }
    return true;
  }

  boolean checkerBussiness(String buss) {
    return (buss.equals("electronics") || buss.equals("grocery") || buss.equals("pharmacy")
        || buss.equals("restaurant"));
  }

  public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
    ArrayList<Element> result = new ArrayList<>();
    int N = code.length;
    for (int index = 0; index < N; index++) {
      if (!isActive[index] || !checkerCode(code[index]) || !checkerBussiness(businessLine[index])) {
        continue;
      }
      String buss = businessLine[index];
      result.add(new Element(code[index], businessLine[index], buss.equals("electronics") ? 0
          : buss.equals("grocery") ? 1 : buss.equals("pharmacy") ? 2 : buss.equals("restaurant") ? 3 : -1));
    }

    Collections.sort(result, (a, b) -> a.value == b.value ? a.code.compareTo(b.code) : a.value - b.value);
    List<String> returnValue = new ArrayList<>();
    for (Element element : result) {
      returnValue.add(element.code);
    }
    return returnValue;
  }
}

class Element {
  String code;
  String type;
  int value;

  Element(String code, String type, int value) {
    this.code = code;
    this.type = type;
    this.value = value;
  }
}