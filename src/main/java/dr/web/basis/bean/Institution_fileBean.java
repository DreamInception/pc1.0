/**
 *	包名:	dr.web.basis.controller
 *	文件名:	Bean.java
 *	描述:	登录相关操作
 *	创建人:	陈吉秋特
 *	创建时间:	2016-3-16下午5:00:00
 *	版权:	2016 景源金服版权所有
 */
package dr.web.basis.bean;
import dr.web.common.bean.BaseBean;
/**
 * 
 * @包名 :dr.web.basis.controller
 * @文件名 :Institution_fileBean.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2014-6-4 上午9:56:20
 * @版本号 :v0.0.01
 */
public class Institution_fileBean  extends BaseBean {

	/**file_id*/public static final String fileId = "fileId" ;                                           /**机构ID*/public static final String instId = "instId" ;                                           /**机构代号*/public static final String instNo = "instNo" ;                                           /**文件远程路径*/public static final String fileRemote_path = "fileRemote_path" ;                                           /**文件本地路径*/public static final String fileLocal_path = "fileLocal_path" ;                                           /**file_name*/public static final String fileName = "fileName" ;                                           /**file_date*/public static final String fileDate = "fileDate" ;                                           /**file_size*/public static final String fileSize = "fileSize" ;                                           /**file_atime*/public static final String fileAtime = "fileAtime" ;                                           /**file_mtime*/public static final String fileMtime = "fileMtime" ;                                           /**产品类型  1：产品文件，2：产品合同，3：投资订单，4：投资订单确认，5,：打款结果，6：每日资产，7：资产赎回*/public static final String fileType = "fileType" ;                                           /**文件编号*/public static final String fileNo = "fileNo" ;                                           /**0：下载，1：上传*/public static final String fileFrom = "fileFrom" ;                                           /**0：未处理，1：已下载，2：下载失败，3：已处理，4：处理失败*/public static final String fileStatus = "fileStatus" ;                                           /**文件处理信息*/public static final String fileHandle_msg = "fileHandle_msg" ;                                           /**file_createtime*/public static final String fileCreatetime = "fileCreatetime" ;                                           /**file_modifytime*/public static final String fileModifytime = "fileModifytime" ;                                           
}
