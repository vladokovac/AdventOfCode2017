import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by vlado on 02/12/2017.
 */
public class Main {
    public static void main(String[] args) {

        // Day 1
        // System.out.printf("" + SumRepeatingDigits
        // ());

        // Day 2
//        System.out.println(calculateMatrixChecksum1(PuzzleInputs.day2));
//        System.out.println(calculateMatrixChecksum2(PuzzleInputs.day2));

        // Day 3
        // GetDistanceToSpiralCenter(325489);

        // Day 7
        String nodeInput = "pbga (66)\n" + "xhth (57)\n" + "ebii (61)\n" + "havc (66)\n" + "ktlj (57)\n" +
                "fwft (72) -> ktlj, cntj, xhth\n" + "qoyq (66)\n" + "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" + "jptl (61)\n" + "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" + "cntj (57)";
        String bottomNodeName = getBottomNodeName(nodeInput);
//        System.out.println(getNodeValueChange(PuzzleInputs.day7));

        // Day 8
//        System.out.println(parseJumpInstructions1(PuzzleInputs.day8));
//        System.out.println(parseJumpInstructions2(PuzzleInputs.day8));

        // Day 9
        String input = PuzzleInputs.day9;
//        System.out.println(calculateStreamScore(input, 0));
        System.out.println(countGarbageInStream(input));
    }

    public static int SumRepeatingDigits(String digits) {
        int sum = 0;
        char[] digitsArray = digits.toCharArray();
        for (int i = 0; i < digits.length() - 1; i++) {
            if (digitsArray[i] == digitsArray[i + 1]) {
                sum += Character.getNumericValue(digitsArray[i]);
            }
        }
        if (digitsArray[0] == digitsArray[digitsArray.length - 1]) {
            sum += Character.getNumericValue(digitsArray[0]);
        }
        return sum;
    }

    /**
     * Calculates checksum by following the rule: Checksum = sum of differences between largest and smallest values
     * in each row.
     *
     * @param matrixString Input.
     * @return The calculated checksum.
     */
    private static int calculateMatrixChecksum1(String matrixString) {
        int checksum = 0;

        String[] matrixRows = matrixString.split("\n");
        for (String row : matrixRows) {
            String[] rowElements = row.split("\t");
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;

            for (String element : rowElements) {
                int elemValue = Integer.valueOf(element);
                if (elemValue < minValue) {
                    minValue = elemValue;
                }
                if (elemValue > maxValue) {
                    maxValue = elemValue;
                }
            }

            checksum += maxValue - minValue;
        }

        return checksum;
    }

    /**
     * Calculates checksum by following the rule: Checksum = sum of one even division from each row in the matrix.
     *
     * @param matrixString Input matrix.
     * @return The calculated checksum.
     */
    private static int calculateMatrixChecksum2(String matrixString) {
        int checksum = 0;

        String[] matrixRows = matrixString.split("\n");
        for (String row : matrixRows) {
            String[] rowElements = row.split("\t");
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;

            for (int i = 0; i < rowElements.length; i++) {
                boolean hasFoundDivisibleElements = false;
                int elemValue1 = Integer.valueOf(rowElements[i]);
                for (int j = 0; j < rowElements.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int elemValue2 = Integer.valueOf(rowElements[j]);

                    if (elemValue1 / elemValue2 > 0 && elemValue1 % elemValue2 == 0) {
                        checksum += elemValue1 / elemValue2;
                        hasFoundDivisibleElements = true;
                        break;
                    }
                }
                if (hasFoundDivisibleElements) {
                    break;
                }
            }
        }

        return checksum;
    }

    public static int GetDistanceToSpiralCenter(int number) {
        int distance = 0;

        int numberReached = 1;
        while (numberReached * numberReached < number) {
            numberReached += 2;
        }

        // TL - BR diagonal coordinates (subtracted by 1 for 0-based index)
        int x = numberReached - 1;
        int y = numberReached - 1;

        int elementsInRow = numberReached;
        boolean hasFound = false;
        // should look left?
        int currentValue = numberReached * numberReached;
        if (currentValue - elementsInRow <= number) {
            x -= currentValue - number;
            hasFound = true;
        } else {
            x -= elementsInRow - 1;
        }
        currentValue -= elementsInRow - 1;

        if (!hasFound) {
            if (currentValue - (elementsInRow - 1) <= number) {
                hasFound = true;
                y -= currentValue - number;
            } else {
                y -= elementsInRow - 1;
            }
        }
        currentValue -= elementsInRow - 1;

        if (!hasFound) {
            if (currentValue - (elementsInRow - 1) <= number) {
                hasFound = true;
                x += currentValue - number;
            } else {
                x += elementsInRow - 1;
            }
        }
        currentValue -= elementsInRow - 1;
        if (!hasFound) {
            if (currentValue - (elementsInRow - 1) < number) {
                hasFound = true;
                y += currentValue - number;
            }
        }


        int spiralCenterX = numberReached / 2;
        int spiralCenterY = numberReached / 2;

        distance = Math.abs(spiralCenterX - x) + Math.abs(spiralCenterY - y);

        System.out.println("(" + String.valueOf(x) + "," + String.valueOf(y) + ")");
        System.out.println("Dist: " + distance);
        return distance;
    }

    private static int CountValidPassphrases(String passphrases) {
        int validCount = 0;

        String[] splitPassphrases = passphrases.split("\n");

        for (String pass : splitPassphrases) {
            Set<String> stringsSet = new HashSet<String>();
            String[] words = pass.split(" ");
            boolean isValid = true;
            for (String word : words) {
                if (stringsSet.contains(word)) {
                    isValid = false;
                    break;
                }
                stringsSet.add(word);
            }

            if (isValid) {
                validCount++;
            }
        }

        return validCount;
    }

    private static int CountValidPassphrasesWithoutAnagrams(String passphrases) {
        int validCount = 0;

        String[] splitPassphrases = passphrases.split("\n");

        for (String pass : splitPassphrases) {
            Set<String> stringsSet = new HashSet<String>();
            String[] words = pass.split(" ");
            boolean isValid = true;
            for (String word : words) {
                char[] letters = word.toCharArray();
                Arrays.sort(letters);
                String sortedWord = String.valueOf(letters);
                if (stringsSet.contains(sortedWord)) {
                    isValid = false;
                    break;
                }
                stringsSet.add(sortedWord);
            }

            if (isValid) {
                validCount++;
            }
        }

        return validCount;
    }

    private static int CountStepsToEndOfMaze(String maze) {
        int steps = 0;

        String[] splitMaze = maze.split("\n");
        List<Integer> mazeList = new ArrayList<Integer>();
        for (String mazePoint : splitMaze) {
            mazeList.add(Integer.valueOf(mazePoint));
        }

        int currentIndex = 0;
        while (currentIndex < mazeList.size()) {
            int oldIndex = currentIndex;
            int jumpValue = mazeList.get(currentIndex);
            currentIndex += jumpValue;
            mazeList.set(oldIndex, jumpValue + 1);
            steps++;
        }

        return steps;
    }

    private static int CountStepsToEndOfMazeWithStrangerJumps(String maze) {
        int steps = 0;

        String[] splitMaze = maze.split("\n");
        List<Integer> mazeList = new ArrayList<Integer>();
        for (String mazePoint : splitMaze) {
            mazeList.add(Integer.valueOf(mazePoint));
        }

        int currentIndex = 0;
        while (currentIndex < mazeList.size()) {
            int oldIndex = currentIndex;
            int jumpValue = mazeList.get(currentIndex);
            currentIndex += jumpValue;
            int jumpUpdate = jumpValue > 2 ? -1 : 1;
            mazeList.set(oldIndex, jumpValue + jumpUpdate);
            steps++;
        }

        return steps;
    }

    private static int countBlockRedistributions(String blockData) {
        int redistributions = 0;

        String[] splitData = blockData.split("\t");
        Integer[] blocks = new Integer[splitData.length];
        for (int i = 0; i < splitData.length; i++) {
            blocks[i] = Integer.valueOf(splitData[i]);
        }

        Set<String> seenCombinations = new HashSet<String>();
        String combinationString = "";

        while (!seenCombinations.contains(combinationString)) {
            seenCombinations.add(combinationString);
            int maxBlockIndex = 0;
            for (int i = 1; i < blocks.length; i++) {
                if (blocks[maxBlockIndex] < blocks[i]) {
                    maxBlockIndex = i;
                }
            }

            int value = blocks[maxBlockIndex];
            blocks[maxBlockIndex] = 0;
            int currentIndex = (maxBlockIndex + 1) % blocks.length;
            while (value > 0) {
                blocks[currentIndex]++;
                value--;
                currentIndex = (currentIndex + 1) % blocks.length;
            }

            combinationString = getCombinationString(blocks);
            redistributions++;
        }

        return redistributions;
    }

    private static int countBlockRedistributionsCycles(String blockData) {
        int redistributions = 0;

        String[] splitData = blockData.split("\t");
        Integer[] blocks = new Integer[splitData.length];
        for (int i = 0; i < splitData.length; i++) {
            blocks[i] = Integer.valueOf(splitData[i]);
        }

        Map<String, Integer> seenCombinations = new HashMap();
        String combinationString = "";

        while (!seenCombinations.containsKey(combinationString)) {
            seenCombinations.put(combinationString, redistributions);
            int maxBlockIndex = 0;
            for (int i = 1; i < blocks.length; i++) {
                if (blocks[maxBlockIndex] < blocks[i]) {
                    maxBlockIndex = i;
                }
            }

            int value = blocks[maxBlockIndex];
            blocks[maxBlockIndex] = 0;
            int currentIndex = (maxBlockIndex + 1) % blocks.length;
            while (value > 0) {
                blocks[currentIndex]++;
                value--;
                currentIndex = (currentIndex + 1) % blocks.length;
            }

            combinationString = getCombinationString(blocks);
            redistributions++;
        }


        return redistributions - seenCombinations.get(combinationString);
    }

    private static String getCombinationString(Integer[] combination) {
        StringBuilder sb = new StringBuilder();
        for (Integer block : combination) {
            sb.append(block);
        }

        return sb.toString();
    }

    private static String getBottomNodeName(String input) {
        AdventNode rootNode = loadNodes(input);
        return rootNode.getName();
    }

    private static int getNodeValueChange(String input) {
        AdventNode root = loadNodes(input);
        List<AdventNode> nodeList = new ArrayList<AdventNode>();
        nodeList.add(root);
        AdventNode differentNode = null;

        while (nodeList.size() > 0) {
            boolean diffNodeChanged = false;
            AdventNode node = nodeList.remove(0);
            if (node.getParent() != null) {
                int nodeWeight = node.getTreeWeight();
                int sameSiblings = 0;
                int diffSiblings = 0;
                for (AdventNode sibling : node.getParent().getChildren()) {
                    if (sibling == node) {
                        continue;
                    }
                    if (nodeWeight == sibling.getTreeWeight()) {
                        sameSiblings++;
                    } else {
                        diffSiblings++;
                    }
                }

                if (sameSiblings == 0 && diffSiblings > 0) {
                    differentNode = node;
                    diffNodeChanged = true;
                    nodeList.clear();
                }
            }

            if (differentNode != null && diffNodeChanged) {
                nodeList.addAll(differentNode.getChildren());
            } else if (differentNode == null) {
                nodeList.addAll(node.getChildren());
            }
        }

        int nodeWeight = 0;
        int weightDifference = 0;
        if (differentNode != null && differentNode.getParent() != null) {
            nodeWeight = differentNode.getNodeWeight();
            AdventNode sibling = null;
            for (AdventNode node : differentNode.getParent().getChildren()) {
                if (node != differentNode) {
                    sibling = node;
                    break;
                }
            }
            if (sibling != null) {
                weightDifference = sibling.getTreeWeight() - differentNode.getTreeWeight();
            }
        }

        return nodeWeight + weightDifference;
    }

    private static AdventNode loadNodes(String input) {
        String[] inputLines = input.split("\n");
        Map<String, AdventNode> nodeDictionary = new HashMap<String, AdventNode>();

        // Load single nodes first, we'll connect them later
        for (String singleLine : inputLines) {
            String[] splitSingleLine = singleLine.split(" -> ");

            // Load node name and weight, data is formatted properly for sure, definitely, no need to check.
            String[] nodeData = splitSingleLine[0].split(" ");
            String nodeName = nodeData[0];
            if (nodeDictionary.containsKey(nodeName)) {
                throw new IllegalArgumentException("Duplicate node " + nodeName + ".");
            }

            String weightData = nodeData[1];
            int weight = Integer.valueOf(weightData.substring(1, weightData.length() - 1));

            AdventNode node = new AdventNode(nodeName, weight);
            nodeDictionary.put(nodeName, node);
        }

        String someNodeName = "";

        for (String singleLine : inputLines) {
            String[] splitSingleLine = singleLine.split(" -> ");
            if (splitSingleLine.length <= 1) {
                continue;
            }

            String[] nodeData = splitSingleLine[0].split(" ");
            String nodeName = nodeData[0];
            AdventNode parentNode = nodeDictionary.get(nodeName);

            String[] childNames = splitSingleLine[1].split(" ");

            for (String childName : childNames) {
                if (childName.endsWith(",")) {
                    childName = childName.substring(0, childName.length() - 1);
                }
                AdventNode childNode = nodeDictionary.get(childName);
                childNode.setParent(parentNode);
                parentNode.addChild(childNode);
                someNodeName = childName;
            }
        }

        AdventNode node = nodeDictionary.get(someNodeName);

        while (node.getParent() != null) {
            node = node.getParent();
        }
        return node;
    }

    /**
     * Parses jump instructions that manipulate register values for an unknown amount of registers.
     *
     * @param instructions The jump instructions.
     * @return The largest register value after all instructions were parsed.
     */
    private static int parseJumpInstructions1(String instructions) {
        int largestRegisterValue = 0;

        String[] instructionArray = instructions.split("\n");

        Map<String, Integer> registerValues = new HashMap<String, Integer>();
        for (String singleInstruction : instructionArray) {
            String[] words = singleInstruction.split(" ");
            String registerName = words[0];
            String command = words[1];
            Integer increaseValue = Integer.valueOf(words[2]);
            String conditionLeft = words[4];
            Integer conditionRight = Integer.valueOf(words[6]);
            String conditionOperator = words[5];
            int registerValue = registerValues.containsKey(registerName) ? registerValues.get(registerName) : 0;

            int conditionLeftValue = registerValues.containsKey(conditionLeft) ? registerValues.get(conditionLeft) : 0;
            boolean isConditionMet = false;
            if (conditionOperator.equals("<")) {
                isConditionMet = conditionLeftValue < conditionRight;
            } else if (conditionOperator.equals("==")) {
                isConditionMet = conditionLeftValue == conditionRight;
            } else if (conditionOperator.equals(">")) {
                isConditionMet = conditionLeftValue > conditionRight;
            } else if (conditionOperator.equals("<=")) {
                isConditionMet = conditionLeftValue <= conditionRight;
            } else if (conditionOperator.equals(">=")) {
                isConditionMet = conditionLeftValue >= conditionRight;
            } else if (conditionOperator.equals("!=")) {
                isConditionMet = conditionLeftValue != conditionRight;
            } else {
                throw new IllegalArgumentException("Unknown operator detected.");
            }

            if (isConditionMet) {
                if (command.toLowerCase().equals("inc")) {
                    registerValue += increaseValue;
                } else if (command.toLowerCase().equals("dec")) {
                    registerValue -= increaseValue;
                } else {
                    throw new IllegalArgumentException("Unknown command detected.");
                }
                registerValues.put(registerName, registerValue);
            }
        }

        for (Integer value : registerValues.values()) {
            largestRegisterValue = value > largestRegisterValue ? value : largestRegisterValue;
        }

        return largestRegisterValue;
    }

    /**
     * Parses jump instructions that manipulate register values for an unknown amount of registers.
     *
     * @param instructions The jump instructions.
     * @return The largest register value held in any register during any step of the process.
     */
    private static int parseJumpInstructions2(String instructions) {
        int largestRegisterValue = 0;

        String[] instructionArray = instructions.split("\n");

        Map<String, Integer> registerValues = new HashMap<String, Integer>();
        for (String singleInstruction : instructionArray) {
            String[] words = singleInstruction.split(" ");
            String registerName = words[0];
            String command = words[1];
            Integer increaseValue = Integer.valueOf(words[2]);
            String conditionLeft = words[4];
            Integer conditionRight = Integer.valueOf(words[6]);
            String conditionOperator = words[5];
            int registerValue = registerValues.containsKey(registerName) ? registerValues.get(registerName) : 0;

            int conditionLeftValue = registerValues.containsKey(conditionLeft) ? registerValues.get(conditionLeft) : 0;
            boolean isConditionMet = false;
            if (conditionOperator.equals("<")) {
                isConditionMet = conditionLeftValue < conditionRight;
            } else if (conditionOperator.equals("==")) {
                isConditionMet = conditionLeftValue == conditionRight;
            } else if (conditionOperator.equals(">")) {
                isConditionMet = conditionLeftValue > conditionRight;
            } else if (conditionOperator.equals("<=")) {
                isConditionMet = conditionLeftValue <= conditionRight;
            } else if (conditionOperator.equals(">=")) {
                isConditionMet = conditionLeftValue >= conditionRight;
            } else if (conditionOperator.equals("!=")) {
                isConditionMet = conditionLeftValue != conditionRight;
            } else {
                throw new IllegalArgumentException("Unknown operator detected.");
            }

            if (isConditionMet) {
                if (command.toLowerCase().equals("inc")) {
                    registerValue += increaseValue;
                } else if (command.toLowerCase().equals("dec")) {
                    registerValue -= increaseValue;
                } else {
                    throw new IllegalArgumentException("Unknown command detected.");
                }
                registerValues.put(registerName, registerValue);
                largestRegisterValue = registerValue > largestRegisterValue ? registerValue : largestRegisterValue;
            }
        }

        return largestRegisterValue;
    }

    private static int calculateStreamScore(String inputStream, int scoreAbove) {

        if (inputStream.length() == 0) {
            return 0;
        }

        int groupValue = scoreAbove + 1;
        int streamScore = 0;
        boolean isInGarbageBlock = false;

        int openGroups = 0;
        List<String> groupsBelowThis = new ArrayList<String>();
        int openGroupIndex = inputStream.length();
        int closeGroupIndex = 0;
        boolean ignoreNextChar = false;
        for (int i = 0; i < inputStream.toCharArray().length; i++) {

            char c = inputStream.toCharArray()[i];
            if (ignoreNextChar) {
                ignoreNextChar = false;
                continue;
            }
            switch (c) {
                case '{':
                    if (isInGarbageBlock) {
                        continue;
                    }
                    if (openGroups == 0) {
                        openGroupIndex = i + 1;
                    }
                    openGroups++;
                    break;
                case '}':
                    if (isInGarbageBlock) {
                        continue;
                    }
                    openGroups--;
                    if (openGroups == 0) {
                        closeGroupIndex = i;
                    }
                    break;
                case '<':
                    isInGarbageBlock = true;
                    break;
                case '>':
                    isInGarbageBlock = false;
                    break;
                case '!':
                    ignoreNextChar = true;
                    break;
                default:
                    break;
            }

            if (openGroupIndex <= closeGroupIndex) {
                groupsBelowThis.add(inputStream.substring(openGroupIndex, closeGroupIndex));
                openGroupIndex = inputStream.length();
                closeGroupIndex = 0;
            }
        }

        streamScore += groupValue * groupsBelowThis.size();

        for (String group : groupsBelowThis) {
            streamScore += calculateStreamScore(group, scoreAbove + 1);
        }

        return streamScore;
    }

    private static int countGarbageInStream(String inputStream) {

        if (inputStream.length() == 0) {
            return 0;
        }
        int garbageCount = 0;
        boolean isInGarbageBlock = false;

        int openGroups = 0;
        List<String> groupsBelowThis = new ArrayList<String>();
        int openGroupIndex = inputStream.length();
        int closeGroupIndex = 0;
        int garbageInBlock = 0;
        boolean ignoreNextChar = false;
        for (int i = 0; i < inputStream.toCharArray().length; i++) {

            char c = inputStream.toCharArray()[i];
            if (ignoreNextChar) {
                ignoreNextChar = false;
                continue;
            }
            switch (c) {
                case '<':
                    openGroups++;
                    if (openGroups == 1) {
                        continue;
                    }
                    break;
                case '>':
                    openGroups--;
                    continue;
                case '!':
                    ignoreNextChar = true;
                    continue;
                default:
                    break;
            }

            if (openGroups > 0) {
                garbageCount++;
            }
        }

        return garbageCount;
    }


}
