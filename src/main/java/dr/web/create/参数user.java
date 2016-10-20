package dr.web.create;

public class 参数user implements Interface参数 {

	public static String table_head = "dr_";

	public static String controller_package = "dr.web.basis.controller";
	public static String service_package = "dr.web.basis.service";
	public static String bean_package = "dr.web.basis.bean";

	public static String controller_filepath = "D:/workspace/dr-web/src/main/java/dr/web/basis/controller/";
	public static String service_filepath = "D:/workspace/dr-web/src/main/java/dr/web/basis/service/";
	public static String mapper_filepath = "D:/workspace/dr-web/src/main/resources/mapper/";
	public static String bean_filepath = "D:/workspace/dr-web/src/main/java/dr/web/basis/bean/";

	@Override
	public String getBeanFilepath() {
		return bean_filepath;
	}

	@Override
	public String getBeanPackage() {
		return bean_package;
	}

	@Override
	public String getControllerFilepath() {
		return controller_filepath;
	}

	@Override
	public String getControllerPackage() {
		return controller_package;
	}

	@Override
	public String getMapperFilepath() {
		return mapper_filepath;
	}

	@Override
	public String getServiceFilepath() {
		return service_filepath;
	}

	@Override
	public String getServicePackage() {
		return service_package;
	}

	@Override
	public String getTableHead() {
		return table_head;
	}
}
