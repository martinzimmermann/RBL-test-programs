import gym
import gym_maze

import time, random, argparse, math

import os
os.environ['SDL_VIDEODRIVER']='dummy'

parser = argparse.ArgumentParser(description='')
parser.add_argument('ENV', help='Name of the environment')
parser.add_argument('N', metavar='N', type=int, help='Number of Actors')
args = parser.parse_args()

COMPASS = {
    "N": (0, -1),
    "E": (1, 0),
    "S": (0, 1),
    "W": (-1, 0)
}

env = gym.make(args.ENV)
obs = env.reset()
actors = [obs]

if args.N != 0:
    spawnX = env.observation_space.high[0]
    spawnDiff = math.floor(spawnX / (args.N))
    for i in range(args.N):
        env.add_robot([spawnX,0])
        spawnX -= spawnDiff

def moveRobotRnd(robot_number):
    dir = random.choice(["N", "E", "S", "W"])
    env.move_robot(dir, robot_number)

#env.render()
#time.sleep(0.1)
prev_obs = obs.copy()
print(obs)
while True:
    # wait for action
    action = int(input())
    obs, _, _, _ = env.step(action)
    for i in range(1, env.number_of_robots):
        moveRobotRnd(i)
    #env.render()
    #time.sleep(0.3)
    print(f'[{obs[0]} {obs[1]}]')
env.close()