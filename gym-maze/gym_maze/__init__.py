from gym.envs.registration import register


register(
    id='maze-v0',
    entry_point='gym_maze.envs:MazeEnvSample5x5',
    max_episode_steps=2000,
)

register(
    id='maze-sample-5x5-v0',
    entry_point='gym_maze.envs:MazeEnvSample5x5',
    max_episode_steps=10000000000000,
)

register(
    id='maze-empty-5x5-v0',
    entry_point='gym_maze.envs:MazeEnvEmpty5x5',
    max_episode_steps=10000000000000,
)

register(
    id='maze-warehouse-5x5-v0',
    entry_point='gym_maze.envs:MazeEnvWarehouse5x5',
    max_episode_steps=10000000000000,
)

register(
    id='maze-warehouse-8x8-v0',
    entry_point='gym_maze.envs:MazeEnvWarehouse8x8',
    max_episode_steps=10000000000000,
)

register(
    id='maze-warehouse-11x11-v0',
    entry_point='gym_maze.envs:MazeEnvWarehouse11x11',
    max_episode_steps=10000000000000,
)

register(
    id='maze-warehouse-14x14-v0',
    entry_point='gym_maze.envs:MazeEnvWarehouse14x14',
    max_episode_steps=10000000000000,
)

register(
    id='maze-warehouse-17x17-v0',
    entry_point='gym_maze.envs:MazeEnvWarehouse17x17',
    max_episode_steps=10000000000000,
)

register(
    id='maze-warehouse-20x20-v0',
    entry_point='gym_maze.envs:MazeEnvWarehouse20x20',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-5x5-v0',
    entry_point='gym_maze.envs:MazeEnvRandom5x5',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-8x8-v0',
    entry_point='gym_maze.envs:MazeEnvRandom8x8',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-11x11-v0',
    entry_point='gym_maze.envs:MazeEnvRandom11x11',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-14x14-v0',
    entry_point='gym_maze.envs:MazeEnvRandom14x14',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-17x17-v0',
    entry_point='gym_maze.envs:MazeEnvRandom17x17',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)
register(
    id='maze-random-20x120-v0',
    entry_point='gym_maze.envs:MazeEnvRandom20x20',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-sample-10x10-v0',
    entry_point='gym_maze.envs:MazeEnvSample10x10',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-10x10-v0',
    entry_point='gym_maze.envs:MazeEnvRandom10x10',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-sample-3x3-v0',
    entry_point='gym_maze.envs:MazeEnvSample3x3',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-3x3-v0',
    entry_point='gym_maze.envs:MazeEnvRandom3x3',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-25x25-v0',
    entry_point='gym_maze.envs:MazeEnvRandom25x25',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-50x50-v0',
    entry_point='gym_maze.envs:MazeEnvRandom50x50',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-60x60-v0',
    entry_point='gym_maze.envs:MazeEnvRandom60x60',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-75x75-v0',
    entry_point='gym_maze.envs:MazeEnvRandom75x75',
    max_episode_steps=10000000000000,
)

register(
    id='maze-sample-100x100-v0',
    entry_point='gym_maze.envs:MazeEnvSample100x100',
    max_episode_steps=10000000000000,
)

register(
    id='maze-random-100x100-v0',
    entry_point='gym_maze.envs:MazeEnvRandom100x100',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-10x10-plus-v0',
    entry_point='gym_maze.envs:MazeEnvRandom10x10Plus',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-20x20-plus-v0',
    entry_point='gym_maze.envs:MazeEnvRandom20x20Plus',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)

register(
    id='maze-random-30x30-plus-v0',
    entry_point='gym_maze.envs:MazeEnvRandom30x30Plus',
    max_episode_steps=10000000000000,
    nondeterministic=True,
)
