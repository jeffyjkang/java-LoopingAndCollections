package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dogs dogArr[];
        dogArr = new Dogs[5];
        // Dogs[] dogArr = new Dogs[5];

        // int temp; temp undefined - 0

        System.out.println("*** Arrays ***");

        dogArr[0] = new Dogs("Springer", 50, false);
        dogArr[1] = new Dogs("Bulldog", 50, true);
        dogArr[2] = new Dogs("Collie", 50, false);
        dogArr[3] = new Dogs("Chihuahua", 5, true);
        dogArr[4] = new Dogs("Corgie", 35, true);
        // dogArr[5] = new Dogs ("Mutt", 15, true);

        // Print out the array
        System.out.println("For Loop");
        for (int i = 0; i < dogArr.length; i++) {
            System.out.println(dogArr[i]);
        }

        System.out.println("Breed 4 good for apartment? " + dogArr[3].isApartment());

        System.out.println("\nprint out array");
        // prints out pointer to array to string
        System.out.println(dogArr.toString());
        // prints out elements inside of the array
        System.out.println(Arrays.toString(dogArr));

        System.out.println("*** Array List ***");
        // create arraylist of type Dogs
        ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
        // convert the array as a list add parameter dogArr and add to dogsArrayList
        dogsArrayList.addAll(Arrays.asList(dogArr));
        // ArrayList does contain order
        dogsArrayList.add(new Dogs("Mutt", 15, true));

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }
        System.out.println();

        for (Dogs d : dogsArrayList) {
            if (d.getAvgWeight() >= 50) {
                System.out.println(d.getBreed() + " are large");
            } else {
                System.out.println(d.getBreed() + " are small");
            }
        }
        System.out.println();

        // if (dogsArrayList.get(2).equals("Turtle")) {
        // System.out.println("We have a Match!!!"); }
        if (dogsArrayList.get(2).getBreed().equals("Turtle")) {
            System.out.println("We have a Match!!!");
        } else {
            System.out.println("No match for " + dogsArrayList.get(2).getBreed());
        }
        System.out.println();

        // adds an element at specified index
        dogsArrayList.add(2, new Dogs("Labrador", 75, false));
        dogsArrayList.forEach(d -> System.out.println(d));
        System.out.println();

        // sets an element at the specified index (replaces)
        dogsArrayList.set(2, new Dogs("Poodle", 50, false));
        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }
        System.out.println();

        // .size method to get size of an ArrayList
        System.out.println("dogArrayList is (size) " + dogsArrayList.size());
        System.out.println(dogsArrayList.get(3));
        dogsArrayList.remove(3);
        // unlike an array, everything automatically shifts up in an ArrayList
        // no empty spots unless manually input as null value
        System.out.println(dogsArrayList.get(3));
        System.out.println();

        // ArrayList has method called iterator
        Iterator<Dogs> iterator = dogsArrayList.iterator();
        // while our iterator has attribute hasNext, iterate
        while (iterator.hasNext()) {
            Dogs tempDog = iterator.next();
            System.out.println(tempDog);
        }
        System.out.println();

        // Collections: arrayList, array, hashMap, set, hashSet, linkedList, etc
        // sort collection pass parameter of array list and new object comparator,
        // comparator compares Dogs
        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            // must be exact, public, type int, compare lowercase
            public int compare(Dogs o1, Dogs o2) {
                // sort alphabetically by breed, ascending
                return o1.getBreed().compareToIgnoreCase(o2.getBreed());
                // sort by avgWeight, ascending
                // return o1.getAvgWeight() - o2.getAvgWeight()
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }
        System.out.println();

        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                // sort in reverse alphabetical order by breed, descending
                return o2.getBreed().compareToIgnoreCase(o1.getBreed());
                // sort by avgWeight, descending
                // return o2.getAvgWeight() - o1.getAvgWeight()
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println("*** HashMap ***");
        // HashMap<KEY,VALUE>, primary key has to be unique, values can be duplicates
        HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();
        int hashCount = 0;
        for (Dogs d : dogsArrayList) {
            // put(KEY, VALUE) key = hashCount, value = d
            // if key does not exist - add
            // if key does exist - replace
            dogsHashMap.put(hashCount, d);
            hashCount++;
        }
        // frees up memory .clear, but gets rid of all data in arraylist
        dogsArrayList.clear();

        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        dogsHashMap.remove(3);
        // returns null from hashmap
        System.out.println(dogsHashMap.get(3));
        // size changed
        System.out.println(dogsHashMap.size());
        System.out.println();

        // no particular order, returns all of the keys we have
        for (Integer i : dogsHashMap.keySet()) {
            System.out.println("key: " + i + " value: " + dogsHashMap.get(i));
        }
        System.out.println();

        // to sort a hashmap create an array list, sort then print out values
        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
        // add all hashmap entries, method in hashmap .entrySet
        sortedMap.addAll(dogsHashMap.entrySet());

        Collections.sort(sortedMap, new Comparator<Map.Entry<Integer, Dogs>>() {
            public int compare(HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2) {
                return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
            }
        });

        // datatype of array list is hashmap entries, array list is sortedMap
        for (HashMap.Entry<Integer, Dogs> d : sortedMap) {
            System.out.println("key: " + d.getKey() + " value: " + d.getValue());
        }
        System.out.println();

        System.out.println("*** HashSet ***");
        // hashset has values that can not be duplicates
        HashSet<String> dogsHashSet = new HashSet<String>();
        dogsHashSet.add("Springer");
        dogsHashSet.add("Mutt");
        dogsHashSet.add("Bulldog");

        for (String d : dogsHashSet) {
            System.out.println(d);
        }
        System.out.println();

        dogsHashSet.add("Mutt");
        for (String d : dogsHashSet) {
            System.out.println(d);
        }

    }
}
