class FreqStack {
    class Element implements Comparable<Element> {
        private final int number;
        private final int freq;
        private final long timestamp;

        public Element(int number, int freq, int timestamp){
            this.number = number;
            this.freq = freq;
            this.timestamp = timestamp;
        }

        public int compareTo(Element o) {
            if (this.freq == o.freq) return Long.compare(o.timestamp, this.timestamp);
            else return Integer.compare(o.freq,this.freq);
        }
    }
    private int timestamp = 0;
    private Map<Integer, Integer> freqMap = new HashMap<>();
    private TreeSet<Element> stack = new TreeSet<>();

    public FreqStack() {

    }

    public void push(int x) {
        freqMap.put(x,freqMap.getOrDefault(x,0)+1);
        stack.add(new Element(x,freqMap.get(x),timestamp++));
    }

    public int pop() {
        Element element = stack.pollFirst();
        int res = -1;
        if (element!=null) {
            res = element.number;
            freqMap.put(res,freqMap.get(res)-1);
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
