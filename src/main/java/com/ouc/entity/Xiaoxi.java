package com.ouc.entity;

public class Xiaoxi {
    private Integer id;
	private String shetuanbianhao;
	private String shetuanmingcheng;
	private String leibie;
	private String tongzhimingcheng;
	private String riqi;
	private String dengjiren;
	private String neirong;
	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShetuanbianhao() {
        return shetuanbianhao;
    }
    public void setShetuanbianhao(String shetuanbianhao) {
        this.shetuanbianhao = shetuanbianhao == null ? null : shetuanbianhao.trim();
    }
	public String getShetuanmingcheng() {
        return shetuanmingcheng;
    }
    public void setShetuanmingcheng(String shetuanmingcheng) {
        this.shetuanmingcheng = shetuanmingcheng == null ? null : shetuanmingcheng.trim();
    }
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
        this.leibie = leibie == null ? null : leibie.trim();
    }
	public String getTongzhimingcheng() {
        return tongzhimingcheng;
    }
    public void setTongzhimingcheng(String tongzhimingcheng) {
        this.tongzhimingcheng = tongzhimingcheng == null ? null : tongzhimingcheng.trim();
    }
	public String getRiqi() {
        return riqi;
    }
    public void setRiqi(String riqi) {
        this.riqi = riqi == null ? null : riqi.trim();
    }
	public String getDengjiren() {
        return dengjiren;
    }
    public void setDengjiren(String dengjiren) {
        this.dengjiren = dengjiren == null ? null : dengjiren.trim();
    }
	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }
	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
