     public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        // check input validation
        if (intervals == null || intervals.size() == 0) return result;

        // sort by start time
        intervals.sort((Interval i1, Interval i2) -> i1.start - i2.start);

        Interval cur = intervals.get(0);

        for(int i = 1; i < intervals.size(); i ++) {
            cur = merge(cur, intervals.get(i), result);
        }
        
        result.add(cur);
        
        return result;
    }

    private Interval merge (Interval i1, Interval i2, List<Interval> result){
        if (i2.start > i1.end) { // can not merge
            result.add(i1);
            return i2;
        } else{ // can merge
            Interval newi = new Interval();
            newi.start = Math.min(i1.start, i2.start);
            newi.end = Math.max(i1.end, i2.end);
            return newi;
        }
    }