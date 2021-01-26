package com.steven.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bundle {

    public Map<Integer, Double> filterBundle(String type) {
        Map<Integer, Double> bundle = new HashMap<>();
        switch (type) {
            case "IMG":
                bundle.put(5, 450.00);
                bundle.put(10, 800.00);
                break;
            case "FLAC":
                bundle.put(3, 427.50);
                bundle.put(6, 810.00);
                bundle.put(9, 1147.50);
                break;
            case "VID":
                bundle.put(3, 570.00);
                bundle.put(5, 900.00);
                bundle.put(9, 1530.00);
                break;
            default:
                bundle.put(0,0.0);
                break;
        }
        return bundle;
    }

    public List<Integer> determineBundle(String type, Map<Integer, Double> bundleMap) {
        List<Integer> bundleNum = new ArrayList<>();
        switch (type) {
            case "IMG":
                bundleMap = filterBundle("IMG");
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            case "FLAC":
                bundleMap = filterBundle("FLAC");
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            case "VID":
                bundleMap = filterBundle("VID");
                bundleNum = new ArrayList<>(bundleMap.keySet());
                break;
            default:
                bundleNum = new ArrayList<>();
                break;
        }
        return bundleNum;
    }

    public int[] convertBundle(List<Integer> bundleList) {
        int[] bundleArray = new int[bundleList.size()];
        for (int i = 0; i < bundleList.size(); i++) {
            bundleArray[i] = bundleList.get(i);
        }
        return bundleArray;
    }
}
