package id.co.syahid.testinovasi.constant;

import java.util.Arrays;
import java.util.List;

import id.co.syahid.testinovasi.response.StatusRes;

public enum TransactionStatus {
    SUCCESS(0, "SUCCESS"),
    FAILED(1, "FAILED");

    private final int id;
    private final String name;

    TransactionStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public static List<StatusRes> toList() {
        return Arrays.stream(values())
                .map(s -> {
                	StatusRes statusRes = new StatusRes();
                	statusRes.setId(s.getId());
                	statusRes.setName(s.getName());
                	return statusRes;
                })
                .toList();
    }
}
