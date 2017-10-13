package ie.sg.sw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Countdown {

	public static void main(String [] args )
	{
		System.out.println("Countdown Game");
		List<Integer> list = Arrays.asList(1, 2, 10, 25, 50, 100);
        for (Integer integer : list) {
            List<Integer> runList = new ArrayList<>(list);
            runList.remove(integer);
            Result result = getOperations(runList, integer, 250);
            if (result.success) {
                System.out.println(integer + result.output);
                return;
            }
        }
	}
	public static class Result
    {

        public String output;
        public boolean success;
    }

    public static Result getOperations(List<Integer> numbers, int midNumber, int target)
    {
        Result midResult = new Result();
        if (midNumber == target) {
            midResult.success = true;
            midResult.output = "";
            return midResult;
        }
        for (Integer number : numbers) {
            List<Integer> newList = new ArrayList<Integer>(numbers);
            newList.remove(number);
            if (newList.isEmpty()) {
                if (midNumber - number == target) {
                    midResult.success = true;
                    midResult.output = "-" + number;
                    return midResult;
                }
                if (midNumber + number == target) {
                    midResult.success = true;
                    midResult.output = "+" + number;
                    return midResult;
                }
                if (midNumber * number == target) {
                    midResult.success = true;
                    midResult.output = "*" + number;
                    return midResult;
                }
                if (midNumber / number == target) {
                    midResult.success = true;
                    midResult.output = "/" + number;
                    return midResult;
                }
                midResult.success = false;
                midResult.output = "f" + number;
                return midResult;
            } else {
                midResult = getOperations(newList, midNumber - number, target);
                if (midResult.success) {
                    midResult.output = "-" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber + number, target);
                if (midResult.success) {
                    midResult.output = "+" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber * number, target);
                if (midResult.success) {
                    midResult.output = "*" + number + midResult.output;
                    return midResult;
                }
                midResult = getOperations(newList, midNumber / number, target);
                if (midResult.success) {
                    midResult.output = "/" + number + midResult.output;
                    return midResult;
                }
            }

        }
        return midResult;
    }
}
