public class Main {
    public static void main(String[] args) {
//        Задание 1. Формирование URL с параметрами
//        Дана строка базового URL:
//        https://example.com/search?
//        Сформируйте полный URL, добавив к нему параметры для поиска. Параметры
//        передаются в виде строки, где ключи и значения разделены =, а пары
//        ключ-значение разделены &. Если значение null, то параметр не должен
//        попадать в URL.
//                Пример:
//        params = "query=java&sort=desc&filter=null"
//        Результат:
//        https://example.com/search?query=java&sort=desc
        String baseUrl = "https://example.com/search?";
        String params = "query=java&sort=desc&filter=null";

        String fullUrl = fullUrl(baseUrl, params);
        System.out.println(fullUrl);

        String[] split = fullUrl.split("\\?");
        String[] param = split[1].split("&");
        String[] split1 = {};
        String[] arrey_params = new String[param.length];
        String[] arrey_value = new String[param.length];
        for (int i = 0; i < param.length; i++) {
            split1 = param[i].split("=");
            arrey_params[i] = split1[0];
            arrey_value[i] = split1[1];
        }
        for (int i = 0; i < param.length; i++) {
            System.out.println(arrey_params[i] + " " + arrey_value[i]);
        }
        System.out.println(fullUrl(baseUrl, fullUrlNewParams(arrey_params, arrey_value)));



    }
    public static String fullUrl(String baseUrl, String params){
        String full_url = "";
        String[] baseUrl_1 = baseUrl.split("");
        if (baseUrl_1[baseUrl_1.length - 1].equals("?")){
            full_url = baseUrl.concat(params);
        } else {
            full_url = baseUrl + "?" + params;
        }
        return full_url;
    }
    public static String fullUrlNewParams(String[] arrey_params, String[] arrey_value){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrey_params.length; i++) {
            if (!arrey_value[i].equals("null")){
                if (i > 0){
                    sb.append("&");
                }
                sb.append(arrey_params[i]).append("=").append(arrey_value[i]);
            }

        }
        String params = sb.toString();
        return params;
    }
}
