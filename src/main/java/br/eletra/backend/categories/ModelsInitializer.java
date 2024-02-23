package br.eletra.backend.categories;

import java.util.*;

public class ModelsInitializer {

    // Método para inicializar os modelos e retornar o mapa de modelos por linha e subcategoria
    public Map<String, Map<String, List<String>>> initializeModels() {
        Map<String, Map<String, List<String>>> modelsPerLine = new HashMap<>();

        Map<String, List<String>> modelsCronos = new LinkedHashMap<>();
        List<String> modelsCronosOld = new ArrayList<>();
        modelsCronosOld.add("Cronos 6001-A");
        modelsCronosOld.add("Cronos 6003");
        modelsCronosOld.add("Cronos 7023");
        modelsCronos.put("Cronos Old", modelsCronosOld);

        List<String> modelsCronosL = new ArrayList<>();
        modelsCronosL.add("Cronos 6021L");
        modelsCronosL.add("Cronos 7023L");
        modelsCronos.put("Cronos L", modelsCronosL);

        List<String> modelsCronosNG = new ArrayList<>();
        modelsCronosNG.add("Cronos 6001‑NG");
        modelsCronosNG.add("Cronos 6003‑NG");
        modelsCronosNG.add("Cronos 6021‑NG");
        modelsCronosNG.add("Cronos 6031‑NG");
        modelsCronosNG.add("Cronos 7021‑NG");
        modelsCronosNG.add("Cronos 7023‑NG");
        modelsCronos.put("Cronos-NG", modelsCronosNG);

        Map<String, List<String>> modelsAres = new LinkedHashMap<>();
        List<String> modelsAresTB = new ArrayList<>();
        modelsAresTB.add("Ares 7021");
        modelsAresTB.add("Ares 7031");
        modelsAresTB.add("Ares 7023");
        modelsAres.put("Ares TB", modelsAresTB);

        List<String> modelsAresTHS = new ArrayList<>();
        modelsAresTHS.add("Ares 8023 15");
        modelsAresTHS.add("Ares 8023 200");
        modelsAresTHS.add("Ares 8023 2,5");
        modelsAres.put("Ares THS", modelsAresTHS);

        modelsPerLine.put("Cronos", modelsCronos);
        modelsPerLine.put("Ares", modelsAres);

        return modelsPerLine;
    }
}