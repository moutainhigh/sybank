package xin.tianchuang.modules.api.bean.api.loan.response.loan;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by yp-tc-m-7179 on 2019/3/14.
 *
 */
@ApiModel(value = "营销报告-天眼查数据-信用历史相关）")
public class MarketApiCreditHisDTO {
    /**
     * 开庭公告
     */
    private List<LoanBizKtannouncementDTO> ktannouncements;

    /**
     * 法院公告
     */
    private List<LoanBizCourtAnnouncementDTO> courtAnnouncements;
    /**
     * 裁判文书
     */
    private List<LoanBizCourtWenShuDTO> courtWenShus;

	/**
	 * 法律诉讼
	 */
	private List<LoanBizLawSuitDTO> lawSuits;

    /**
     * 执行公告
     */
    private List<LoanBizZhixinginfoDTO> zhixinginfos;

    /**
     * 失信公告
     */
    private List<LoanBizDishonestDTO> dishonests;

    public List<LoanBizKtannouncementDTO> getKtannouncements() {
        return ktannouncements;
    }

    public void setKtannouncements(List<LoanBizKtannouncementDTO> ktannouncements) {
        this.ktannouncements = ktannouncements;
    }

    public List<LoanBizCourtAnnouncementDTO> getCourtAnnouncements() {
        return courtAnnouncements;
    }

    public void setCourtAnnouncements(List<LoanBizCourtAnnouncementDTO> courtAnnouncements) {
        this.courtAnnouncements = courtAnnouncements;
    }

    public List<LoanBizCourtWenShuDTO> getCourtWenShus() {
        return courtWenShus;
    }

    public void setCourtWenShus(List<LoanBizCourtWenShuDTO> courtWenShus) {
        this.courtWenShus = courtWenShus;
    }

    public List<LoanBizLawSuitDTO> getLawSuits() {
        return lawSuits;
    }

    public void setLawSuits(List<LoanBizLawSuitDTO> lawSuits) {
        this.lawSuits = lawSuits;
    }

    public List<LoanBizZhixinginfoDTO> getZhixinginfos() {
        return zhixinginfos;
    }

    public void setZhixinginfos(List<LoanBizZhixinginfoDTO> zhixinginfos) {
        this.zhixinginfos = zhixinginfos;
    }

    public List<LoanBizDishonestDTO> getDishonests() {
        return dishonests;
    }

    public void setDishonests(List<LoanBizDishonestDTO> dishonests) {
        this.dishonests = dishonests;
    }
}
