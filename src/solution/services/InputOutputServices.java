package solution.services;

import solution.search.SearchEngine;
import solution.model.PhoneInfo;

import java.util.List;

public class InputOutputServices {

    private final SearchEngine searchEngine = new SearchEngine();
    private final PhoneInfoServices phoneInfoServices = new PhoneInfoServices();

    public SearchEngine getSearchEngine() {
        return searchEngine;
    }

    public PhoneInfoServices getPhoneInfoServices() {
        return phoneInfoServices;
    }

    public void checkNumbers(List<PhoneInfo> base, List<Long> core, StringBuilder result) {
        findNumber(base, core, result);
    }

    private void findNumber(List<PhoneInfo> base, List<Long> core, StringBuilder result) {
        for (long value : core) {
            int firstIndex = getSearchEngine().getFirstIndex(base, value);
            int lastIndex = getSearchEngine().getLastIndex(base, value);

            if (firstIndex == -1 || lastIndex == -1) {
                result.append(getPhoneInfoServices().printNoInfo(value));
            } else {
                for (int i = firstIndex; i < lastIndex; i++) {
                    result.append(base.get(i).toString());
                }
            }
        }
    }
}
