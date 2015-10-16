package se.eklann.codearbiter.executor;

/**
 *
 * @author eklann
 */
public interface ContainerBuilder {
    /**
     * Builds a docker container containing the specified executable.
     * @param executablePath The executable to put in the container.
     * @param containerPath The path to save the container to.
     */
    public void BuildContainer(String executablePath, String containerPath);
}
