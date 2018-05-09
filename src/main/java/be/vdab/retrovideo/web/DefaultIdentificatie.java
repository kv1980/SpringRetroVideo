package be.vdab.retrovideo.web;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
class DefaultIdentificatie implements Identificatie,Serializable {
	private static final long serialVersionUID = 1L;
	private long klantId;
	
	public long getKlantId() {
		return klantId;
	}
	public void setKlantId(long klantId) {
		this.klantId = klantId;
	}
}