public List<String> fizzBuzz(int n) {
    final String MUL_THREE = "Fizz";
    final String MUL_FIVE = "Buzz";

    List<String> result = new ArrayList<>();

    // loop through number 1 to n
    for (int i = 1; i <= n; i ++) {
        String output = String.valueOf(i);

        if (i % (3 * 5) == 0) {
            output = MUL_THREE + MUL_FIVE;
        } else if (i % 3 == 0) {
            output = MUL_THREE;
        } else if (i % 5 == 0) {
            output = MUL_FIVE;
        }

        result.add(output);
    }

    return result;
}