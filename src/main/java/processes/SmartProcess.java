package processes;

import dto.VectorDto;
import entities.Smart;
import org.apache.commons.lang3.tuple.Pair;
import services.VectorService;

import java.util.*;

public class SmartProcess {
    private VectorService vectorService;
    private Smart smart = new Smart();

    public SmartProcess(VectorService vectorService) {
        this.vectorService = vectorService;
    }

    public SmartProcess() {
        this(new VectorService());
    }

    public List<Pair<VectorDto, VectorDto>> getPairs() {
        List<Pair<VectorDto, VectorDto>> result = new ArrayList<>();
        List<VectorDto> all = vectorService.findAll();
        for (int i = 0; i < all.size() - 1; i++) {
            for (int j = i + 1; j < all.size(); j++) {
                result.add(Pair.of(all.get(i), all.get(j)));
            }
        }

        return result;
    }

    public String[][] makeMatrix(Map<Pair<String, String>, String> request) {
        String[][] matrix = new String[request.keySet().size()][request.values().size()];
        Set keys = new HashSet();
        keys = request.keySet();
        matrix[0][0] = "head";
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][i] = "=";
            matrix[0][i] = "";
            matrix[i][0] = "";
        }
        return matrix;
    }

}
