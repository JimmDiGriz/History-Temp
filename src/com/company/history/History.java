package com.company.history;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<String> history;
    private int pointer;
    private String startUrl;

    private List<String> getHistory() {
        return history;
    }

    private void setHistory(List<String> value) {
        history = value;
    }

    private int getPointer() {
        return pointer;
    }

    private void setPointer(int value) throws HistoryPointerException {
        if (value >= 0) {
            pointer = value;
        } else {
            throw new HistoryPointerException("Trying set a history pointer less then zero.");
        }
    }

    private String getStartUrl() {
        return startUrl;
    }

    private void setStartUrl(String value) {
        startUrl = value;
    }

    public History(String startUrl) {
        setHistory(new ArrayList<String>());

        try {
            setPointer(0);
        } catch (HistoryPointerException exception) {
            exception.printStackTrace();
        }

        setStartUrl(startUrl);
    }

    public void add(String item) throws HistoryAddingException {
        /*this check prevent adding a start page to history twice.*/
        if (getHistory().size() > 0 && item == getStartUrl()) {
             return;
        } else {
            if (getPointer() < getHistory().size() - 1) {
                for (int i = getHistory().size() - 1; i > getPointer(); i--) {
                    getHistory().remove(i);
                }
            }

            if (!getHistory().add(item)) {
                throw new HistoryAddingException("Adding history item failed.");
            }

            try {
                setPointer(getHistory().size() - 1);
            } catch (HistoryPointerException exception) {
                exception.printStackTrace();
            }
        }
    }

    public String goBack() throws HistoryGoBackException {
        if (getPointer() > 0) {
            try {
                setPointer(getPointer() - 1);
            } catch (HistoryPointerException e) {
                e.printStackTrace();
            }

            return getHistory().get(getPointer());
        } else {
            throw new HistoryGoBackException("Previous history is empty");
        }
    }

    public String goForward() throws HistoryGoForwardException {
        if (getPointer() < getHistory().size() - 1) {
            try {
                setPointer(getPointer() + 1);
            } catch (HistoryPointerException e) {
                e.printStackTrace();
            }

            return getHistory().get(getPointer());
        } else {
            throw new HistoryGoForwardException("Forward history is empty.");
        }
    }

    public String getCurrent() throws HistoryGetException{
        if (getHistory().size() > 0) {
            return getHistory().get(getPointer());
        } else {
            throw new HistoryGetException("History doesn't exists.");
        }
    }
}
