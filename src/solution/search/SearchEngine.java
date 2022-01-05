package solution.search;

import solution.model.PhoneInfo;

import java.util.List;

public class SearchEngine {

    public int getFirstIndex(List<PhoneInfo> base, long phone) {
        return findFirstIndex(base, phone);
    }

    public int getLastIndex(List<PhoneInfo> base, long phone) {
        return findLastIndex(base, phone);
    }

    private int findFirstIndex(List<PhoneInfo> base, long value) {
        int n = base.size();
        int good = n;
        int bad = -1;

        while (good - bad > 1) {
            int m = (good + bad) / 2;
            if (base.get(m).getNumber() >= value)
                good = m;
            else bad = m;
        }
        if (good != n && base.get(good).getNumber() == value)
            return good;
        else return -1;
    }

    private int findLastIndex(List<PhoneInfo> list, long value) {
        int good = list.size();
        int bad = -1;

        while (good - bad > 1) {
            int m = (good + bad) / 2;
            if (list.get(m).getNumber() > value)
                good = m;
            else bad = m;
        }
        if (good == list.size())
            return -1;
        return good;
    }
}
