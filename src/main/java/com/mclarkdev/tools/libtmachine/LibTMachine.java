package com.mclarkdev.tools.libtmachine;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class LibTMachine {

	private final DatagramSocket serverSocket;

	private final InetAddress clockAddr;

	public LibTMachine(String clock) throws IOException {

		serverSocket = new DatagramSocket();
		clockAddr = InetAddress.getByName(clock);
	}

	/**
	 * Sends a command to the clock. Switch mode to [Clock].
	 * 
	 * @return command sent
	 */
	public boolean setModeClock() {
		return send(new byte[] { (byte) 0xA8, (byte) 0x01, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. Switch mode to [Count Down].
	 * 
	 * @return command sent
	 */
	public boolean setModeDown() {
		return send(new byte[] { (byte) 0xA5, (byte) 0x00, (byte) 0x00, //
				(byte) 0x0F, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. Switch mode to [Count Up].
	 * 
	 * @return command sent
	 */
	public boolean setModeUp() {
		return send(new byte[] { (byte) 0xA2, (byte) 0x00, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. [Pause] when in mode [Count Up].
	 * 
	 * @return command sent
	 */
	public boolean pauseModeUp() {
		return send(new byte[] { (byte) 0xA3, (byte) 0x00, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. [Pause] when in mode [Count Down].
	 * 
	 * @return command sent
	 */
	public boolean pauseModeDown() {
		return send(new byte[] { (byte) 0xA6, (byte) 0x00, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. [Start] when in mode [Count Up].
	 * 
	 * @return command sent
	 */
	public boolean startModeUp() {
		return send(new byte[] { (byte) 0xA3, (byte) 0x01, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. [Start] when in mode [Count Down].
	 * 
	 * @return command sent
	 */
	public boolean startModeDown() {
		return send(new byte[] { (byte) 0xA6, (byte) 0x01, (byte) 0x00 });
	}

	/**
	 * Sends a command to the clock. Toggles the on-board relay for 3 seconds.
	 * 
	 * @return command sent
	 */
	public boolean toggleRelay() throws IOException {
		return send(new byte[] { (byte) 0xB4, (byte) 0x01, (byte) 0x00 });
	}

	/**
	 * Sends a command to the device.
	 * 
	 * @param buff
	 * @return command sent
	 */
	private boolean send(byte[] buff) {

		try {
			serverSocket.send(//
					new DatagramPacket(buff, buff.length, clockAddr, 7372));
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
