package se.eklann.codearbiter.executor;

//TODO: This can probably be an abstract class with a convenience method to
//      actually build the container, so that the implementing classes only 
//      needs to produce the Dockerfile, and put contents in the right folder.

/**
 *
 * @author eklann
 */
public interface ContainerBuilder { 
    /**
     * Builds a docker container containing the specified executable.
     * @param contextDirectory The docker context directory to use to build the 
     * container.
     * @param executableName The path to the executable, which is already in 
     * the context directory.
     * @param containerName The name of the container to build.
     */
    public void BuildContainer(String contextDirectory, 
            String executableName, String containerName);
}
