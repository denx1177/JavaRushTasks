package com.javarush.task.task19.task1918;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String tag = args[0];
        String filename;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename = console.readLine();
//            filename = "C:\\Users\\de1177\\Documents\\java\\de1177\\JavaRushTasks\\resourses\\myFile14.txt";
        }
        String inputText = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                inputText += br.readLine();
            }
        }
//        Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.

        List<Tag> tagList = findAllTags(inputText, tag);
        for (Tag tag1 : tagList) {
            System.out.println(inputText.substring(tag1.getStartIndex(), tag1.getEndIndex()));
        }
    }

    public static List<Tag> findAllTags(String inputString, String tag) {
        Tag currentTag = new Tag(0);
        List<Tag> tagList = new ArrayList<>();
        Pattern pattern = Pattern.compile("<(/?" + tag + ")[^>]*?>");
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            if (matcher.group(1).equals(tag)) {
                currentTag = new Tag(matcher.start(), currentTag);
                tagList.add(currentTag);
            } else if (matcher.group(1).equals("/" + tag)) {
                currentTag.setEndIndex(matcher.end());
                currentTag = currentTag.getUpTag();
            }
        }
        return tagList;
    }

    public static class Tag {
        private int startIndex;
        private int endIndex;
        Tag upTag;

        public Tag(int startIndex) {
            this.startIndex = startIndex;
        }

        public Tag(int startIndex, Tag tag) {
            this.startIndex = startIndex;
            this.upTag = tag;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public Tag getUpTag() {
            return upTag;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

    }
}
