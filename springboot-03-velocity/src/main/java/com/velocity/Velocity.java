package com.velocity;

import org.springframework.stereotype.Component;

@Component
public final class Velocity {

	private VelocityTemplate identityInfo;

	private VelocityTemplate number;

	public VelocityTemplate getIdentityInfo() {
		return identityInfo;
	}

	public void setIdentityInfo(VelocityTemplate identityInfo) {
		this.identityInfo = identityInfo;
	}

	public VelocityTemplate getNumber() {
		return number;
	}

	public void setNumber(VelocityTemplate number) {
		this.number = number;
	}
}
