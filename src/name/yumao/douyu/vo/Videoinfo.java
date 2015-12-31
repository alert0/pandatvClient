package name.yumao.douyu.vo;


public class Videoinfo {

	@Override
	public String toString() {
		return "VideoinfoEntity [name=" + name + ", stream_addr="
				+ stream_addr + ", plflag=" + plflag + ", sign="
				+ sign + ", time=" + time + ", room_key="
				+ room_key + ", status=" + status + ", ts=" + ts
				+ "]";
	}
	
    public static int STREAM_TYPE_360 = 1;
    public static int STREAM_TYPE_UNKNOWN = 0;
	
	
	 public boolean getStreamAddress(String strStreamType, StringBuffer strAddress) {
	        boolean v4 = true;
	        int v1 = 0;
	        String v2 = "";
	        try {
	            String[] v3 = this.plflag.split("_");
	            if(v3.length > 0 && !v3[0].isEmpty()) {
	                v1 = Integer.parseInt(v3[0]);
	            }

	            if(v3.length > 1) {
	                v2 = v3[1];
	            }

	            if(v1 == STREAM_TYPE_UNKNOWN) {
	                return false;
	            }

	            if(v1 == STREAM_TYPE_360) {
	                return v4;
	            }

	            strAddress.append(String.format("http://pl%s.live.panda.tv/live_panda/%s%s.flv", v2, this.room_key, strStreamType));
	            return v4;
	        }
	        catch(Exception v0) {
	            v0.printStackTrace();
	        }

	        return false;
	    }


	/**
	 * name : dota stream_addr : {"SD":"1","OD":"1","HD":"1"} plflag
	 * : 2_3 sign : sign time : 8478 room_key :
	 * 98136e97f549e01b24095ad85bbeb12f status : 2 ts : ts
	 */
	private String name;
	private Stream_addrEntity stream_addr;
	private String plflag;
	private String sign;
	private String time;
	private String room_key;
	private String status;
	private String ts;

	public void setName(String name) {
		this.name = name;
	}

	public void setStream_addr(Stream_addrEntity stream_addr) {
		this.stream_addr = stream_addr;
	}

	public void setPlflag(String plflag) {
		this.plflag = plflag;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setRoom_key(String room_key) {
		this.room_key = room_key;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getName() {
		return name;
	}

	public Stream_addrEntity getStream_addr() {
		return stream_addr;
	}

	public String getPlflag() {
		return plflag;
	}

	public String getSign() {
		return sign;
	}

	public String getTime() {
		return time;
	}

	public String getRoom_key() {
		return room_key;
	}

	public String getStatus() {
		return status;
	}

	public String getTs() {
		return ts;
	}

	public class Stream_addrEntity {
		/**
		 * SD : 1 OD : 1 HD : 1
		 */
		private String SD;
		private String OD;
		private String HD;

		public void setSD(String SD) {
			this.SD = SD;
		}

		public void setOD(String OD) {
			this.OD = OD;
		}

		public void setHD(String HD) {
			this.HD = HD;
		}

		public String getSD() {
			return SD;
		}

		public String getOD() {
			return OD;
		}

		public String getHD() {
			return HD;
		}
	}
	

	
	
}