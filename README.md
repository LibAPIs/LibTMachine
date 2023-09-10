# LibTMachine

Basic UDP controller for TimeMachine clocks.

## Maven Dependency

Include the library in your project by adding the following dependency to your pom.xml

```
<dependency>
	<groupId>com.mclarkdev.tools</groupId>
	<artifactId>libtmachine</artifactId>
	<version>1.5.1</version>
</dependency>
```

## Example

Simply create a new instance of LibTMachine with the device IP, then send commands!

```
// Create the device controller
LibTMachine tMachine = new LibTMachine("192.168.10.240");

// Set to count-up
tMachine.setModeUp();

// Start counting
tMachine.startModeUp();
```

# License

Open source & free for all. ❤
