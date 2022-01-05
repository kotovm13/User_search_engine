package solution.programmFlow;

import solution.model.PhoneInfo;
import solution.view.Window;

import java.util.ArrayList;
import java.util.List;

public class Flow {
    private List<PhoneInfo> base;
    private List<Long> core = new ArrayList<>();
    private StringBuilder result;

    public void setBase(List<PhoneInfo> base) {
        this.base = base;
    }

    public void setCore(List<Long> core) {
        this.core = core;
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }

    public void run() {
        setBase(new ArrayList<>());
        setResult(new StringBuilder());

        Window.getIo().formBaseList(base);

        if (core.size() == 0) {
            Window.getIo().formCoreList(core);
        }

        Window.getIo().getInputOutputServices().checkNumbers(base, core, result);

        Window.getIo().getOutput(result);
    }
}
