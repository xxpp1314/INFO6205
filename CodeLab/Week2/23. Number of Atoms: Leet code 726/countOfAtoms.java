class Solution {
    public String countOfAtoms(String formula) {
        LinkedList<Integer> recordFrontBracket = new LinkedList<>();
        int len = formula.length();
        ArrayList<String> atoms = new ArrayList<>(len);
        ArrayList<Integer> counts = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                recordFrontBracket.add(atoms.size());
            } else if (c == ')') {
                int number = 0;
                while (i + 1 < len && isDigital(formula.charAt(i + 1))) {
                    number = number * 10 + formula.charAt(i + 1) - '0';
                    i++;
                }
                if (number == 0) {
                    number = 1;
                }
                int index = recordFrontBracket.removeLast();
                for (int j = index; j < counts.size(); j++) {
                    counts.set(j, counts.get(j) * number);
                }
            } else if (isUpperCase(c)) {
                int t = i;
                while (t + 1 < len && isLowerCase(formula.charAt(t + 1))) {
                    t++;
                }
                atoms.add(formula.substring(i, t + 1));
                i = t;                
                int count = 0;
                while (i + 1 < len && isDigital(formula.charAt(i + 1))) {
                    count = count * 10 + formula.charAt(i + 1) - '0';
                    i++;
                }
                if (count == 0) {
                    count = 1;
                }
                counts.add(count);
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < atoms.size(); i++) {
            map.put(atoms.get(i), map.getOrDefault(atoms.get(i), 0) + counts.get(i));
        }
        String[] arr = new String[map.size()];
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            arr[index] = iterator.next().getKey();
            index++;
        }
        Arrays.sort(arr);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            int count = map.get(arr[i]);
            res.append(count != 1 ? count : "");
        }
        return res.toString();
    }

    public boolean isDigital(char c){
        return c >= '0' && c <= '9';
    }

    public boolean isUpperCase(char c){
        return c >= 'A' && c <= 'Z';
    }

    public boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }
}
