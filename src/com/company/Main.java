package com.company;

import com.company.history.*;

public class Main {

    public static void main(String[] args) {
        History history = new History("start_url_here");

        try {
            history.add("start_url_here");
        } catch (HistoryAddingException e) {
            e.printStackTrace();
        }

        try {
            history.add("second_url_here");
        } catch (HistoryAddingException e) {
            e.printStackTrace();
        }

        try {
            history.add("third_url_here");
        } catch (HistoryAddingException e) {
            e.printStackTrace();
        }

        try {
            history.add("fourth_url_here");
        } catch (HistoryAddingException e) {
            e.printStackTrace();
        }

        try {
            history.add("start_url_here");
        } catch (HistoryAddingException e) {
            e.printStackTrace();
        }

        try {
            history.goBack();
        } catch (HistoryGoBackException e) {
            e.printStackTrace();
        }

        try {
            history.goForward();
        } catch (HistoryGoForwardException e) {
            e.printStackTrace();
        }

        try {
            history.goBack();
        } catch (HistoryGoBackException e) {
            e.printStackTrace();
        }

        try {
            history.add("random_url_here");
        } catch (HistoryAddingException e) {
            e.printStackTrace();
        }
    }
}
