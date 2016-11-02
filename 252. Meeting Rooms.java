    //Method 1: check each pair of intervals whether there is overlap
    //Method 2:
    //1. suppose the interval are valid Interval[i,j], i < j
    //2. sort by start time
    //3. loop through the intervals, I[i,j], I[i+1,j+1], i+1 >= j
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1) return true;

        sortInterval(intervals);

        for(int i = 0; i < intervals.length - 1; i ++){
            if(intervals[i].end > intervals[i + 1].start) return false;
        }

        return true;
     }

    private void sortInterval(Interval[] intervals){
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
    }