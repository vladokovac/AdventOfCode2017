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
        // ("5672987533353956199629683941564528646262567117433461547747793928322958646779832484689174151918261551689221756165598898428736782194511627829355718493723961323272136452517987471351381881946883528248611611258656199812998632682668749683588515362946994415852337196718476219162124978836537348924591957188827929753417884942133844664636969742547717228255739959316351852731598292529837885992781815131876183578461135791315287135243541659853734343376618419952776165544829717676988897684141328138348382882699672957866146524759879236555935723655326743713542931693477824289283542468639522271643257212833248165391957686226311246517978319253977276663825479144321155712866946255992634876158822855382331452649953283788863248192338245943966269197421474555779135168637263279579842885347152287275679811576594376535226167894981226866222987522415785244875882556414956724976341627123557214837873872723618395529735349273241686548287549763993653379539445435319698825465289817663294436458194867278623978745981799283789237555242728291337538498616929817268211698649236646127899982839523784837752863458819965485149812959121884771849954723259365778151788719941888128618552455879369919511319735525621198185634342538848462461833332917986297445388515717463168515123732455576143447454835849565757773325367469763383757677938748319968971312267871619951657267913817242485559771582167295794259441256284168356292785568858527184122231262465193612127961685513913835274823892596923786613299747347259254823531262185328274367529265868856512185135329652635938373266759964119863494798222245536758792389789818646655287856173534479551364115976811459677123592747375296313667253413698823655218254168196162883437389718167743871216373164865426458794239496224858971694877159591215772938396827435289734165853975267521291574436567193473814247981877735223376964125359992555885137816647382139596646856417424617847981855532914872251686719394341764324395254556782277426326331441981737557262581762412544849689472281645835957667217384334435391572985228286537574388834835693416821419655967456137395465649249256572866516984318344482684936625486311718525523265165"));

        // Day 2
//        String matrixInput = "121\t59\t141\t21\t120\t67\t58\t49\t22\t46\t56\t112\t53\t111\t104\t130\n" +
//                "1926\t1910\t760\t2055\t28\t2242\t146\t1485\t163\t976\t1842\t1982\t137\t1387\t162\t789\n" +
//                "4088\t258\t2060\t1014\t4420\t177\t4159\t194\t2794\t4673\t4092\t681\t174\t2924\t170\t3548\n" +
//                "191\t407\t253\t192\t207\t425\t580\t231\t197\t382\t404\t472\t164\t571\t500\t216\n" +
//                "4700\t1161\t168\t5398\t5227\t5119\t252\t2552\t4887\t5060\t1152\t3297\t847\t4525\t220\t262\n" +
//                "2417\t992\t1445\t184\t554\t2940\t209\t2574\t2262\t1911\t2923\t204\t2273\t2760\t506\t157\n" +
//                "644\t155\t638\t78\t385\t408\t152\t360\t588\t618\t313\t126\t172\t220\t217\t161\n" +
//                "227\t1047\t117\t500\t1445\t222\t29\t913\t190\t791\t230\t1281\t1385\t226\t856\t1380\n" +
//                "436\t46\t141\t545\t122\t86\t283\t124\t249\t511\t347\t502\t168\t468\t117\t94\n" +
//                "2949\t3286\t2492\t2145\t1615\t159\t663\t1158\t154\t939\t166\t2867\t141\t324\t2862\t641\n" +
//                "1394\t151\t90\t548\t767\t1572\t150\t913\t141\t1646\t154\t1351\t1506\t1510\t707\t400\n" +
//                "646\t178\t1228\t1229\t270\t167\t161\t1134\t193\t1312\t1428\t131\t1457\t719\t1288\t989\n" +
//                "1108\t1042\t93\t140\t822\t124\t1037\t1075\t125\t941\t1125\t298\t136\t94\t135\t711\n" +
//                "112\t2429\t1987\t2129\t2557\t1827\t477\t100\t78\t634\t352\t1637\t588\t77\t1624\t2500\n" +
//                "514\t218\t209\t185\t197\t137\t393\t555\t588\t569\t710\t537\t48\t309\t519\t138\n" +
//                "1567\t3246\t4194\t151\t3112\t903\t1575\t134\t150\t4184\t3718\t4077\t180\t4307\t4097\t1705";
//        System.out.println(calculateMatrixChecksum1(matrixInput));
//        System.out.println(calculateMatrixChecksum2(matrixInput));

        // Day 3
        // GetDistanceToSpiralCenter(325489);
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
                        checksum += elemValue1/elemValue2;
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
            Set<String> stringsSet = new HashSet<>();
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
            Set<String> stringsSet = new HashSet<>();
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
        List<Integer> mazeList = new ArrayList<>();
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
        List<Integer> mazeList = new ArrayList<>();
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

        Set<String> seenCombinations = new HashSet<>();
        String combinationString = "";

        while (!seenCombinations.contains(combinationString)) {
            seenCombinations.add(combinationString);
            int maxBlockIndex = 0;
            for (int i = 1; i < blocks.length; i++) {
                if (blocks[maxBlockIndex] < blocks[i] ) {
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
                if (blocks[maxBlockIndex] < blocks[i] ) {
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
}
